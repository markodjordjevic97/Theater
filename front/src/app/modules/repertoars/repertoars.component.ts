import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-repertoars',
  templateUrl: './repertoars.component.html',
  styleUrls: ['./repertoars.component.scss']
})
export class RepertoarsComponent implements OnInit {

  stepCounter: number = 0;
  data: any;

  constructor() { }

  ngOnInit(): void {
  }

  onWriter($event) {
    if($event === 1) {
      this.stepCounter = $event;
      return;
    }
    this.stepCounter++;
    this.data = {
      ...$event
    }
  }
  
  onType($event) {
    if($event === 0) {
      this.stepCounter = $event;
      return;
    }
    if($event === 2) {
      this.stepCounter = $event;
      return;
    }
    this.stepCounter++;
    this.data = {
      ...$event
    }
  }

  onPerformance($event) {
    if($event === 1) {
      this.stepCounter = $event;
      return;
    }
    this.stepCounter++;
    this.data = {
      ...this.data,
      ...$event
    }
  }

  again() {
    this.stepCounter = 0;
  }
  
}
