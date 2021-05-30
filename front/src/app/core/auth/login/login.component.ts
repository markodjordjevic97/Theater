import { SharedService } from './../../../shared/services/shared.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/shared/services/Auth.service';
import { NotificationService } from 'src/app/shared/services/notification.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;

  constructor(
    private builder: FormBuilder,
    private authService: AuthService,
    private router: Router,
    private notificationService: NotificationService,
    private shared: SharedService
  ) {
    if(this.authService.currentUserValue) {
      this.router.navigate(['/'])
    }
  }

  ngOnInit() {
    this.initForm();
  }

  private initForm() {
    this.loginForm = this.builder.group({
      username: [null, Validators.required],
      password: [null, Validators.required],
    });
  }

  login() {
    if (!this.shared.markInvalid(this.loginForm)) {
      return false;
    }
    this.authService.signIn(this.loginForm.value).subscribe((data) => {
      if (data) {
        this.notificationService.success('Uspesno ste se ulogovali','Dobro dosli')
        this.router.navigate(['/']);
      }
      else {
        this.notificationService.error('Zao nam je, ne postoji takav account','Greska')
      }
    });
  }
}
