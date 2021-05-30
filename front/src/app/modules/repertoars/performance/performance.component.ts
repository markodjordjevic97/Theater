import { NotificationService } from './../../../shared/services/notification.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { PerformancesService } from 'src/app/shared/services/performances.service';
import { forkJoin} from 'rxjs';

@Component({
  selector: 'app-performance',
  templateUrl: './performance.component.html',
  styleUrls: ['./performance.component.scss'],
})
export class PerformanceComponent implements OnInit {
  @Output() perfromancEmit = new EventEmitter<any>();

  performanceForm: FormGroup;

  writerGroup: any[] = [];

  typeGroup: any[] = [];

  typeModel: any = null;
  writerModel: any = null;


  constructor(
    private builder: FormBuilder,
    private notificationService: NotificationService,
    private performanceService: PerformancesService
  ) {}

  ngOnInit() {
    this.initForm();
    forkJoin({
      writerSubscripton: this.performanceService.getWriter(),
      typeSubsciption: this.performanceService.getType()
    }).subscribe(({writerSubscripton,typeSubsciption }) => {
     
      this.writerGroup = writerSubscripton;
      this.typeGroup = typeSubsciption;
    })
  }

  private initForm() {
    this.performanceForm = this.builder.group({
      title: ['', Validators.required],
      description: ['', Validators.required],
      duration: ['', Validators.required],
      type: ['', Validators.required],
      writer: ['', Validators.required],
    });
  }

  onSelectWriter($event) {
    this.performanceForm.get('writer').patchValue($event);
  }

  onSelectType($event) {
    this.performanceForm.get('type').patchValue($event);
  }

  back() {
    this.perfromancEmit.emit(1);
  }

  addPerformance() {
    if (this.performanceForm.invalid) {
      this.notificationService.error('Proverite jos jednom unos podataka...');
      return;
    }
    this.performanceService.addPerformances(this.performanceForm.value)
    this.perfromancEmit.emit(this.performanceForm.value);
  }
}
