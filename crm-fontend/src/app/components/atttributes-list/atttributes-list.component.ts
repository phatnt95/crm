import { Component } from '@angular/core';
import { RouterOutlet, RouterLink, RouterLinkActive } from '@angular/router';
import { MatTabsModule } from '@angular/material/tabs';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';

// import { AttributesControllerService } from '../../api/api/attributesController.service';
// import { Category } from '../../api/model/category';
export interface PeriodicElement {
    name: string;
    position: number;
    weight: number;
    symbol: string;
}

const ELEMENT_DATA: PeriodicElement[] = [
    { position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H' },
    { position: 2, name: 'Helium', weight: 4.0026, symbol: 'He' },
    { position: 3, name: 'Lithium', weight: 6.941, symbol: 'Li' },
    { position: 4, name: 'Beryllium', weight: 9.0122, symbol: 'Be' },
    { position: 5, name: 'Boron', weight: 10.811, symbol: 'B' },
    { position: 6, name: 'Carbon', weight: 12.0107, symbol: 'C' },
    { position: 7, name: 'Nitrogen', weight: 14.0067, symbol: 'N' },
    { position: 8, name: 'Oxygen', weight: 15.9994, symbol: 'O' },
    { position: 9, name: 'Fluorine', weight: 18.9984, symbol: 'F' },
    { position: 10, name: 'Neon', weight: 20.1797, symbol: 'Ne' },
];
@Component({
    selector: 'app-atttributes-list',
    imports: [MatTabsModule, MatCardModule, MatButtonModule, MatTableModule, MatPaginatorModule, RouterLink],
    templateUrl: './atttributes-list.component.html',
    styleUrl: './atttributes-list.component.css',
})
export class AtttributesListComponent {
    // constructor(private attributesService: AttributesControllerService) {
    //   attributesService.getAttributes({ type: 'category' }).subscribe((data) => {
    //     console.log(data);
    //   });
    // }
    // categories: Category[] = [];
    displayedColumns: string[] = ['position', 'name', 'weight', 'symbol'];
    dataSource = ELEMENT_DATA;
    clickedRows = new Set<PeriodicElement>();

    openCategoryDialog(): void {}
}
