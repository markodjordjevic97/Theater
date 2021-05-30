import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Config } from 'protractor';
import { AuthService } from 'src/app/shared/services/Auth.service';
import { NotificationService } from 'src/app/shared/services/notification.service';
import { SharedService } from 'src/app/shared/services/shared.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  messageRegistration?: any = null;

  constructor(
    private builder: FormBuilder,
    private shared: SharedService,
    private authService: AuthService,
    private notificationService: NotificationService
  ) {}

  ngOnInit() {
    this.initForm();
  }

  private initForm() {
    this.registerForm = this.builder.group({
      username: [null, Validators.required,Validators.maxLength(20)],
      email: [null, [Validators.required, Validators.email]],
      password: [null, Validators.required, Validators.maxLength(120)],
    });
  }

  register() {
    if (!this.shared.markInvalid(this.registerForm)) {
      // this.notificationService.warning('Molimo Vas popunite lepo podatke, proverite Vas unos jos jednom.',
      // 'Upozorenje:');
      return false;
    }
    const user = {
      username: this.registerForm.get('username').value,
      email: this.registerForm.get('email').value,
      role: [],
      password: this.registerForm.get('password').value,
    };
    this.authService.signUp(user).subscribe((res) => {
      this.messageRegistration = res;
      if (
        this.messageRegistration.message === 'User registered successfully!'
      ) {
        this.notificationService.success('Uspesno ste kreirali nalog!');
        this.shared.successfullRegistration.next(false);
      }
    });
  }
}
