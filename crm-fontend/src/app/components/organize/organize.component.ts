import { Component, OnInit, inject, Inject } from '@angular/core';

import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import {
  FormBuilder,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import {
  MatCheckboxModule,
  MatCheckboxChange,
} from '@angular/material/checkbox';
import { HttpContext } from '@angular/common/http';
import { MatListModule } from '@angular/material/list';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';

import {
  MatBottomSheet,
  MatBottomSheetModule,
  MatBottomSheetRef,
  MAT_BOTTOM_SHEET_DATA,
} from '@angular/material/bottom-sheet';
import {
  Bin,
  BinControllerService,
  LocationControllerService,
  ProductControllerService,
  Location,
  StorageControllerService,
  CabinetControllerService,
  Cabinet,
  Brand,
  Neckline,
  Occasion,
  SeasonCode,
  Shoulder,
  AttributesControllerService,
  ProductDTO,
} from '../../api';
import {
  Product,
  Category,
  Color,
  Size,
  Style,
  Tag,
  SleeveLength,
  Type,
} from '../../api';
import { InventoryRequest } from '../../api';
import { InventoryControllerService, Storage } from '../../api';
@Component({
  selector: 'app-organize',
  imports: [
    CommonModule,
    MatCardModule,
    MatCheckboxModule,
    FormsModule,
    MatButtonModule,
    MatBottomSheetModule,
    MatIconModule,
    MatFormFieldModule,
    MatSelectModule,
    MatListModule,
    ReactiveFormsModule,
  ],
  templateUrl: './organize.component.html',
  styleUrl: './organize.component.css',
})
export class OrganizeComponent implements OnInit {
  products: Product[] = []; // Initialize products array
  productForm: FormGroup;
  product: Product | undefined;
  productDTOs: ProductDTO[] = [];
  imagePreview: string | null = null;
  categories: Category[] = [];
  types: Type[] = [];
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
  sleeveLengthOps: SleeveLength[] = [];
  constructor(
    private productService: ProductControllerService,
    private attributesService: AttributesControllerService,
    private fb: FormBuilder
  ) {
    this.productForm = fb.group({
      category: [''],
      color: [''],
      size: [''],
      style: [''],
      tag: [''],
      sleeveLength: [''],
      image: [''],
    });
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
      error: (error) => {
        console.error('Error fetching categories', error);
      },
    });
  }
  isSelected = false;
  private _bottomSheet = inject(MatBottomSheet);
  openBottomSheet(): void {
    if (this.selectedProducts.length === 0) {
      alert('No products selected'); // Log a warning if no products are selected
      return; // Do not open the bottom sheet if no products are selected
    }
    this._bottomSheet.open(BottomSheetOverviewExampleSheet, {
      data: this.selectedProducts,
    });
  }
  ngOnInit(): void {
    // Initialization logic here
    this.productService
      .getAllItems('body', false, {
        httpHeaderAccept: 'application/json', // Example header
        context: new HttpContext(), // Optional context
        transferCache: true, // Enable transfer cache if supported
      })
      //   .getAllItems()
      .subscribe(
        (data: ProductDTO[]) => {
          console.log('Fetched products:', data); // Log the fetched products
          this.productDTOs = data; // Assign the fetched products to the component's products property
          //   data.forEach((product: ProductDTO) => {
          //     product.imageUrl = product.imageUrls?.[0] ?? ''; // Set the imageUrl property for each product with a fallback
          //   });

          console.log('Products:', this.productDTOs); // Log the products
        },
        (error) => {
          console.error('Error fetching products:', error); // Handle error
        }
      );
  }
  //   selectedProducts: Product[] = [];
  selectedProducts: ProductDTO[] = [];
  check(event: MatCheckboxChange, product: ProductDTO) {
    if (event.checked) {
      this.selectedProducts.push(product);
    } else {
      this.selectedProducts = this.selectedProducts.filter(
        (p) => p.productId !== product.productId
      );
    }
    console.log('Selected Products:', this.selectedProducts);
  }

  onReset() {}
  // Add any methods or properties needed for the component here
}

@Component({
  selector: 'bottom-sheet-overview-example-sheet',
  templateUrl: 'bottom-sheet-overview-example-sheet.html',
  styleUrl: './organize.component.css',
  imports: [
    CommonModule,
    MatListModule,
    FormsModule,
    MatFormFieldModule,
    MatSelectModule,
    MatButtonModule,
    MatBottomSheetModule,
    ReactiveFormsModule,
  ],
})
export class BottomSheetOverviewExampleSheet {
  locationOptions: Location[] = []; // Initialize storage options array
  storageOptions: Storage[] = []; // Initialize storage options array
  cabinetOptions: Cabinet[] = []; // Initialize storage options array
  binOptions: Bin[] = []; // Initialize storage options array
  private _bottomSheetRef =
    inject<MatBottomSheetRef<BottomSheetOverviewExampleSheet>>(
      MatBottomSheetRef
    );
  constructor(
    @Inject(MAT_BOTTOM_SHEET_DATA) public data: any[],
    private inventoryService: InventoryControllerService,
    private locationService: LocationControllerService,
    private cabinetService: CabinetControllerService,
    private storageService: StorageControllerService,
    private binService: BinControllerService,
    private fb: FormBuilder
  ) {
    // console.log('Bottom sheet data:', data); // Log the data passed to the bottom sheet
    // this.inventoryService.findAll().subscribe(
    //     (data: any) => {
    //         console.log('Selected products saved successfully:', data); // Handle success
    //         this.storageOptions = data; // Assign the fetched storage options to the component's storageOptions property
    //     },
    //     (error) => {
    //         console.error('Error saving selected products:', error); // Handle error
    //     }
    // );
    this.locationService.findLocations().subscribe(
      (data: any) => {
        console.log('Fetched locations:', data); // Log the fetched bins
        this.locationOptions = data; // Assign the fetched bins to the component's binOptions property
      },
      (error) => {
        console.error('Error fetching bins:', error); // Handle error
      }
    );
    this.storageService.findStorages().subscribe(
      (data: any) => {
        console.log('Fetched storages:', data); // Log the fetched bins
        this.storageOptions = data; // Assign the fetched bins to the component's binOptions property
      },
      (error) => {
        console.error('Error fetching bins:', error); // Handle error
      }
    );
    this.cabinetService.findCabinets().subscribe(
      (data: any) => {
        console.log('Fetched cabinets:', data); // Log the fetched bins
        this.cabinetOptions = data; // Assign the fetched bins to the component's binOptions property
      },
      (error) => {
        console.error('Error fetching bins:', error); // Handle error
      }
    );
    this.binService.findBins().subscribe(
      (data: any) => {
        console.log('Fetched cabinets:', data); // Log the fetched bins
        this.binOptions = data; // Assign the fetched bins to the component's binOptions property
      },
      (error) => {
        console.error('Error fetching bins:', error); // Handle error
      }
    );

    this.inventoryForm = this.fb.group({
      storageName: ['', Validators.required],
      binName: ['', Validators.required],
    });
    this.selectedProductIds = this.data; // Assign the selected products to the component's selectedProductIds property
  }
  selectedProductIds: Array<Product> | undefined; // Array to hold selected product IDs
  // formData = {
  //     location: '',
  //     storageName: Storage,
  //     boxNo: '',
  // };
  inventoryForm: FormGroup;
  storage: Storage | undefined; // Use the imported Storage type
  inventoryRequest: InventoryRequest | undefined; // Initialize inventoryRequest to null
  locations = ['Warehouse A', 'Warehouse B', 'Warehouse C'];
  storageNames = ['Shelf 1', 'Shelf 2', 'Shelf 3'];
  boxNumbers = ['Box 001', 'Box 002', 'Box 003'];

  onSubmit() {
    // console.log('Form submitted:', this.formData);
    console.log('Form submitted:', this.inventoryForm?.value);
    this.storage = this.storageOptions.find((item) => {
      return item.uuId === this.inventoryForm.value.storageName;
    });
    console.log('Storage:', this.storage);
    this.inventoryRequest = {
      productIDs: this.selectedProductIds
        ?.map((product) => product.productId)
        .filter((id): id is number => id !== undefined), // Map selected products to their IDs and filter out undefined
      storageId: this.storage?.uuId, // Use the uuId of the selected storage
      binId: this.inventoryForm.value.binName, // Use the selected bin name
      // storage: this.storage,
      // productList: this.selectedProductIds,
    };
    console.log('Inventory Request:', this.inventoryRequest); // Log the inventory request object
    this.inventoryService.createInventory(this.inventoryRequest).subscribe(
      (data) => {
        console.log('Selected products saved successfully:', data); // Handle success
      },
      (error) => {
        console.error('Error saving selected products:', error); // Handle error
      }
    );
  }

  openLink(event: MouseEvent): void {
    this._bottomSheetRef.dismiss();
    event.preventDefault();
  }
}
