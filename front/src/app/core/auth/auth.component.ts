import { Subscription } from 'rxjs';
import { SharedService } from 'src/app/shared/services/shared.service';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { AuthService } from 'src/app/shared/services/Auth.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.scss'],
})
export class AuthComponent implements OnInit, OnDestroy {
  switcherState: boolean = false;

  private subscripitons: Subscription[] = [];

  constructor(private shared: SharedService) {}

  ngOnInit(): void {
    this.subscripitons.push(
      this.shared.successfullRegistration.subscribe((data) => {
        this.switcherState = data;
      })
    );
  }

  toggleSignUp() {
    this.switcherState = true;
  }

  toggleSignIn() {
    this.switcherState = false;
  }

  ngOnDestroy(): void {
    this.subscripitons.forEach((data) => data.unsubscribe());
  }
}
