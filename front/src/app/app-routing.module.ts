import { BaseComponent } from './base/base.component';
import { AuthGuard } from './core/guards/auth.guard';
import { AppComponent } from './app.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthRepository } from './core/guards/repository.guard';

const routes: Routes = [
  {
    path: '',
    component: BaseComponent,
    canActivate: [AuthGuard],
    children: [
      { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
      {
        path: 'dashboard',
        loadChildren: () =>
          import('./modules/dashboard/dashboard.module').then(
            (m) => m.DashboardModule
          ),
      },
      {
        path: 'tickets',
        loadChildren: () =>
          import('./modules/tickets/tickets.module').then(
            (m) => m.TicketsModule
          ),
      },
      {
        path: 'shows',
        loadChildren: () =>
          import('./modules/shows/shows.module').then((m) => m.ShowsModule),
      },
      {
        path: 'account',
        loadChildren: () =>
          import('./modules/account/account.module').then(
            (m) => m.AccountModule
          ),
      },
      {
        path: 'repertoars',
        canActivate: [AuthRepository],
        loadChildren: () =>
          import('./modules/repertoars/repertoars.module').then(
            (m) => m.RepertoarsModule
          ),
      },
    ],
  },
  {
    path: 'auth',
    loadChildren: () =>
      import('./core/auth/auth.module').then((m) => m.AuthModule),
  },
  { path: '**', redirectTo: '' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
