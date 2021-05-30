import { WriterComponent } from './writer/writer.component';
import { PerformanceComponent } from './performance/performance.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RepertoarsRoutingModule } from './repertoars-routing.module';
import { RepertoarsComponent } from './repertoars.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from 'src/app/shared/shared.module';
import { TypePerformanceComponent } from './type-performance/type-performance.component';

import { NgSelectModule } from '@ng-select/ng-select';
@NgModule({
  declarations: [
    RepertoarsComponent,
    PerformanceComponent,
    WriterComponent,
    TypePerformanceComponent,
  ],
  imports: [
    CommonModule,
    RepertoarsRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    SharedModule,
    NgSelectModule,
  ]
})
export class RepertoarsModule { }