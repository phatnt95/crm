import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  FormBuilder,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import {
  IonContent,
  IonHeader,
  IonTitle,
  IonToolbar,
} from '@ionic/angular/standalone';
import { IonicModule } from '@ionic/angular';
import { Router } from '@angular/router';

import {
  Category,
  Color,
  Size,
  Style,
  SleeveLength,
  Tag,
  Product,
  Shoulder,
  Neckline,
  Occasion,
  Brand,
  // Type,
  SeasonCode,
  AttributesControllerService,
  ProductControllerService,
} from '../api';
@Component({
  selector: 'app-stock-up',
  templateUrl: './stock-up.page.html',
  styleUrls: ['./stock-up.page.scss'],
  standalone: true,
  imports: [
    // IonContent,
    // IonHeader,
    // IonTitle,
    // IonToolbar,
    CommonModule,
    FormsModule,
    IonicModule,
    ReactiveFormsModule,
  ],
})
export class StockUpPage implements OnInit {
  @ViewChild('fileInput') fileInput!: ElementRef<HTMLInputElement>;
  isLoading = false;
  productForm: FormGroup;
  product: Product | undefined;
  imagePreview: string | null = null;
  categories: Category[] = [];
  // types: Type[] = [];
  colors: Color[] = [];
  sizes: Size[] = [];
  styles: Style[] = [];
  // tags: Tag[] = [];
  sleeveLengths: SleeveLength[] = [];
  shoulders: Shoulder[] = [];
  necklines: Neckline[] = [];
  occasions: Occasion[] = [];
  brands: Brand[] = [];
  seasonCodes: SeasonCode[] = [];
  // Trigger input from button
  triggerFileInput(): void {
    this.fileInput.nativeElement.click();
  }
  // productImages: string[] = [];
  constructor(
    private router: Router,
    // private sanitizer: DomSanitizer,
    private fb: FormBuilder,
    private productService: ProductControllerService,
    private attributesService: AttributesControllerService
  ) {
    this.productForm = fb.group({
      name: ['', Validators.required],
      code: [''],
      description: ['', Validators.required],
      category: ['', Validators.required],
      type: [''],
      color: ['', Validators.required],
      brand: ['', Validators.required],
      size: ['', Validators.required],
      style: [''],
      tag: [''],
      sleeveLength: ['', Validators.required],
      occasion: ['', Validators.required],
      seasonCode: ['', Validators.required],
      shoulder: ['', Validators.required],
      neckline: ['', Validators.required],
      image: [''],
    });
  }
  images: File[] = [];
  imagePreviews: string[] = [];
  resizedImage: string | null = null; // To store the resized image data URL
  // Handle file selection

  //

  onImageChange(event: any): void {
    const input = event.target as HTMLInputElement;
    if (!input.files || input.files.length === 0) return;

    this.imagePreviews = [];
    this.images = [];

    Array.from(input.files).forEach((file: File) => {
      const reader = new FileReader();

      reader.onload = (e: any) => {
        const img = new Image();
        img.onload = () => {
          const canvas = document.createElement('canvas');

          const MAX_WIDTH = 600; // bạn có thể chỉnh lại kích thước mong muốn
          const scaleSize = MAX_WIDTH / img.width;
          const width = MAX_WIDTH;
          const height = img.height * scaleSize;

          canvas.width = width;
          canvas.height = height;

          const ctx = canvas.getContext('2d');
          if (ctx) {
            ctx.drawImage(img, 0, 0, width, height);
            const resizedDataUrl = canvas.toDataURL('image/jpeg', 0.7); // Chất lượng 0.7

            this.imagePreviews.push(resizedDataUrl);
            this.images.push(file); // Lưu file gốc nếu cần upload
          }
        };

        img.src = e.target.result;
      };

      reader.readAsDataURL(file);
    });

    // Clear input để chọn lại cùng file không bị lỗi
    setTimeout(() => (input.value = ''), 0);
  }

  resizeImage(img: HTMLImageElement) {
    const canvas = document.createElement('canvas');
    const maxWidth = 400; // Giảm kích thước chiều ngang
    const scale = maxWidth / img.width;
    canvas.width = maxWidth;
    canvas.height = img.height * scale;

    const ctx = canvas.getContext('2d');
    ctx?.drawImage(img, 0, 0, canvas.width, canvas.height);

    this.resizedImage = canvas.toDataURL('image/jpeg', 0.7); // 0.7 là chất lượng nén
  }

  ngOnInit() {
    // initialize the options for the autocomplete
    this.attributesService.findAllAttributes().subscribe({
      next: (data: any) => {
        console.log(data);
        this.categories = data.categories;
        this.colors = data.colors;
        this.sizes = data.sizes;
        // this.styles = data.styles;
        // this.tagOps = data.tags;
        this.sleeveLengths = data.sleeve_lengths;
        this.brands = data.brands;
        this.occasions = data.occasions;
        this.shoulders = data.shoulders;
        this.necklines = data.necklines;
        this.seasonCodes = data.season_codes;
      },
      error: (error: any) => {
        console.error('Error fetching categories', error);
      },
    });
  }

  onSubmit() {
    console.log(this.productForm.invalid);
    console.log('Form submitted:', this.productForm.value);

    if (this.productForm.invalid) {
      this.productForm.markAllAsTouched(); // ✅ mark all fields as touched to show validation errors
      return;
    } // ✅ check if form is valid
    this.isLoading = true;
    console.log('Form submitted:', this.productForm.value);
    this.product = {
      productName: this.productForm.value.name,
      description: this.productForm.value.description,
      category: this.categories?.find((item) => {
        return item.id === this.productForm.value.category;
      }),
      // type: this.types.find((item) => {
      //   return item.id === this.productForm.value.type;
      // }),
      brand: this.brands.find((item) => {
        return item.id === this.productForm.value.brand;
      }),
      color: this.colors.find((item) => {
        return item.colorId === this.productForm.value.color;
      }),
      neckline: this.necklines.find((item) => {
        return item.id === this.productForm.value.neckline;
      }),
      size: this.sizes.find((item) => {
        return item.id === this.productForm.value.size;
      }),
      style: this.styles.find((item) => {
        return item.id === this.productForm.value.style;
      }),
      seasonCode: this.seasonCodes.find((item) => {
        return item.id === this.productForm.value.seasonCode;
      }),
      shoulder: this.shoulders.find((item) => {
        return item.id === this.productForm.value.shoulder;
      }),
      occasion: this.occasions.find((item) => {
        return item.id === this.productForm.value.occasion;
      }),
      // tag: this.tags.find((item) => {
      //     return item.tagId === this.productForm.value.tag;
      // }),
      sleeveLength: this.sleeveLengths.find((item) => {
        return item.id === this.productForm.value.sleeveLength;
      }),
      price: 3000000,
    };

    this.productService.createProduct(this.product, this.images).subscribe({
      next: (response: any) => {
        console.log('Product created:', response);
        // this.router.navigate(['/products', response.productId]);
        this.isLoading = false;
        console.log(this.isLoading);
        // this.snackBar
        //   .open('Product created!', 'Go to Organize', {
        //     duration: 2000,
        //   })
        //   // .afterDismissed()
        //   .onAction()
        //   .subscribe(() => {
        //     // this.router.navigate(['/products', response.productId]);
        //     this.router.navigate(['/organize']);
        //   });
      },
      error: (err: any) => {
        // console.error('Error creating product:', err);
        this.isLoading = false; // ✅ hide spinner on error
        console.log(this.isLoading);

        console.log('Error creating product:', err);
        // this.snackBar.open('Failed to create product', 'Dismiss', {
        //   duration: 3000,
        // }); // ✅ show error message
      },
    });
  }
}
