import { Routes } from '@angular/router';
import { StockUpComponent } from './components/stock-up/stock-up.component';
import { OrganizeComponent } from './components/organize/organize.component';
import { HomeComponent } from './components/home/home.component';
import { FavoratesComponent } from './components/favorates/favorates.component';
import { PreviewComponent } from './components/preview/preview.component';

export const routes: Routes = [
	{ path: '', redirectTo: 'home', pathMatch: 'full' },
	{ path: 'home', component: HomeComponent },
	{
		path: 'stock-up',
		component: StockUpComponent,
	},
	{
		path: 'organize',
		component: OrganizeComponent,
	},
	{
		path: 'preview',
		component: PreviewComponent,
	},
];
