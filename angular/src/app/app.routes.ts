import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: 'projects',
    loadComponent: () => import('./features/projects/projects').then((m) => m.Projects),
  },
];
