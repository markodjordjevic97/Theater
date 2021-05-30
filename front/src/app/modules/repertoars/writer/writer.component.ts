import { NotificationService } from './../../../shared/services/notification.service';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Moment } from 'moment';
import { PerformancesService } from 'src/app/shared/services/performances.service';

@Component({
  selector: 'app-writer',
  templateUrl: './writer.component.html',
  styleUrls: ['./writer.component.scss']
})
export class WriterComponent implements OnInit {

  writerForm: FormGroup;
  @Output() writerEmit = new EventEmitter<any>();

  selected: {startdDate: Moment, endDate: Moment};

  constructor(private builder: FormBuilder, private notificationService: NotificationService, private performanceService: PerformancesService) { }

  ngOnInit() {
    this.initForm();
  }

  private initForm() {
    this.writerForm = this.builder.group({
      name: ['', [Validators.required, Validators.minLength(3)]],
      surname: ['', [Validators.required, Validators.minLength(5)]],
      birthDate: ['', Validators.required]
    })
  }

  preskoci() {
    this.writerForm.clearValidators();
    this.writerEmit.emit(1);
  }

  addWriter() {
    if(this.writerForm.invalid) {
      this.notificationService.error('Proverite jos jednom unos podataka...')
      return;
    }
    this.writerEmit.emit(this.writerForm.value)
    this.performanceService.addWriter(this.writerForm.value)
  }
}
