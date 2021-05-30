import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RepertoarsComponent } from './repertoars.component';

const routes: Routes = [{ path: '', component: RepertoarsComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RepertoarsRoutingModule { }
