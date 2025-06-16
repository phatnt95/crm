import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'folder/inbox',
    pathMatch: 'full',
  },
  {
    path: 'folder/:id',
    loadComponent: () =>
      import('./folder/folder.page').then((m) => m.FolderPage),
  },
  {
    path: 'stock-up',
    loadComponent: () =>
      import('./stock-up/stock-up.page').then((m) => m.StockUpPage),
  },
  {
    path: 'organize',
    loadComponent: () => import('./organize/organize.page').then( m => m.OrganizePage)
  },
];
