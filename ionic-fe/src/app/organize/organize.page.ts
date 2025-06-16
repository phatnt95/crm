import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
// import { IonContent, IonHeader, IonTitle, IonToolbar } from '@ionic/angular/standalone';
import { IonicModule } from '@ionic/angular';
import { ReactiveFormsModule, FormBuilder, FormGroup } from '@angular/forms';
import { Bin, Cabinet, Location, ProductDTO, Storage } from '../api';

@Component({
  selector: 'app-organize',
  templateUrl: './organize.page.html',
  styleUrls: ['./organize.page.scss'],
  standalone: true,
  imports: [IonicModule, ReactiveFormsModule, CommonModule, FormsModule],
})
export class OrganizePage implements OnInit {
  productDTOs: ProductDTO[];
  locationOptions: Location[] = []; // Initialize storage options array
  storageOptions: Storage[] = []; // Initialize storage options array
  cabinetOptions: Cabinet[] = []; // Initialize storage options array
  binOptions: Bin[] = [];
  constructor() {
    this.productForm = this.fb.group({
      // Add relevant form controls
    });
    this.inventoryForm = this.fb.group({
      storageName: '',
      binName: '',
    });

    // Fake data for demo
    this.productDTOs = [
      {
        productName: 'T-Shirt',
        description: 'Cool cotton tee',
        price: 25,
        imageUrl: 'https://via.placeholder.com/300',
      },
    ];
  }
  // Typically referenced to your ion-router-outlet
  presentingElement!: HTMLElement | null;
  ngOnInit() {
    this.presentingElement = document.querySelector('.ion-page');
  }

  fb = inject(FormBuilder);
  productForm: FormGroup;
  inventoryForm: FormGroup;

  openBottomSheet() {
    console.log('Bottom sheet clicked');
    // TODO: Use Ionic modal or alert here
  }

  check(event: any, product: any) {
    console.log('Checkbox changed:', event.checked, product);
  }

  onReset() {
    this.productForm.reset();
  }
  public actionSheetButtons = [
    {
      text: 'Delete',
      role: 'destructive',
      data: {
        action: 'delete',
      },
    },
    {
      text: 'Share',
      data: {
        action: 'share',
      },
    },
    {
      text: 'Cancel',
      role: 'cancel',
      data: {
        action: 'cancel',
      },
    },
  ];
}
