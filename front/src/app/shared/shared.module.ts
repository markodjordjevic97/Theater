import { MaterialModule } from './../modules/material/material.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TheaterTableComponent } from './theater-table/theater-table.component';

@NgModule({
  declarations: [TheaterTableComponent],
  imports: [CommonModule, MaterialModule],
  exports: [TheaterTableComponent],
})
export class SharedModule {}
