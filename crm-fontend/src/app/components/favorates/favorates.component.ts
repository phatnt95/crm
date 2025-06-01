import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
	CdkDragDrop,
	moveItemInArray,
	transferArrayItem,
	CdkDrag,
	CdkDropList,
	DragDropModule,
} from '@angular/cdk/drag-drop';

@Component({
	selector: 'app-favorates',
	imports: [DragDropModule, CommonModule, CdkDrag, CdkDropList],
	templateUrl: './favorates.component.html',
	styleUrl: './favorates.component.css',
})
export class FavoratesComponent {
	cards = ['Card 1', 'Card 2', 'Card 3'];
	droppedCards: string[] = [];
	header: string[] = [];
	body: string[] = [];
	footer: string[] = [];

	// onDropToRight(event: CdkDragDrop<string[]>) {
	// 	if (event.previousContainer !== event.container) {
	// 		transferArrayItem(
	// 			event.previousContainer.data,
	// 			event.container.data,
	// 			event.previousIndex,
	// 			event.currentIndex
	// 		);
	// 	}
	// }

	// Optional: support reordering inside center (if needed)
	// onDrop(event: CdkDragDrop<string[]>) {
	// 	this.droppedCards.push(this.cards[event.previousIndex]);
	// }

	onDropHeader(event: CdkDragDrop<string[]>) {
		this.header.push(this.cards[event.previousIndex]);
	}
	onDropBody(event: CdkDragDrop<string[]>) {
		this.body.push(this.cards[event.previousIndex]);
	}
	onDropFooter(event: CdkDragDrop<string[]>) {
		this.footer.push(this.cards[event.previousIndex]);
	}
}
