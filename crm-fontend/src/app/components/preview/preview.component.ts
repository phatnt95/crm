import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { ProductControllerService, ProductDTO } from '../../api';
import { MatInputModule } from '@angular/material/input';
@Component({
	selector: 'app-preview',
	imports: [CommonModule, MatCardModule, MatButtonModule, MatInputModule],
	templateUrl: './preview.component.html',
	styleUrl: './preview.component.css',
})
export class PreviewComponent {
	productDTOs: ProductDTO[] = [];
	headerImg: string | undefined;
	bodyImg: string | undefined;
	footerImg: string | undefined;
	constructor(private productService: ProductControllerService) {
		// initializing products.
		this.productService.getAllItems().subscribe({
			next: (v) => {
				console.log(v);
				this.productDTOs = v;
			},
			error: (e) => console.error(e),
			complete: () => console.info('complete'),
		});
	}

	tryme(product: ProductDTO) {
		// This method is called when the "Try Me" button is clicked.
		// It should trigger the product service to fetch products.
		console.log('Try Me button clicked');

		this.footerImg = product.imageUrl;
		// filter by category and populate right posision of category.
		// let selectdProduct = this.productDTOs.find((product) => {
		// 	product.category === 'electronics';
		// });
		switch (product.category) {
			case 'electronics':
				console.log('Electronics category selected');
				// Add logic to handle electronics category
				break;
			case 'clothing':
				console.log('Clothing category selected');
				// Add logic to handle clothing category
				break;
			case 'home':
				console.log('Home category selected');
				// Add logic to handle home category
				break;
			default:
				this.footerImg = product?.imageUrl;
		}
	}

	handleEnter(event: any) {}
}
