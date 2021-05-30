import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { UserUpdateService } from 'src/app/shared/services/user-update.service';
import { tap } from 'rxjs/operators';


@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss'],
})
export class AccountComponent implements OnInit {
  accountForm: FormGroup;

  constructor(private builder: FormBuilder, private userUpdateService: UserUpdateService) {}

  ngOnInit(): void {
    this.initForm();
   

    if(JSON.parse(localStorage.getItem('USER_DATA'))) {
      const user = JSON.parse(localStorage.getItem('USER_DATA'));

      if(user) {
        this.accountForm.patchValue({
          username: user.username,
          email: user.email,
          password: ''
        })
      }
    }
   
  }

  private initForm() {
    this.accountForm = this.builder.group({
      username: [null, [Validators.required,Validators.maxLength(20)]],
      email: [null, [Validators.required, Validators.email]],
      password: [null, [Validators.required, Validators.maxLength(120)]],
    });
  }

  update() {
    const data = JSON.parse(localStorage.getItem('USER_DATA'));
    const updateUser = {
      id: data.id,
      username: this.accountForm.get('username').value,
      email: this.accountForm.get('email').value,
      password: this.accountForm.get('password').value,
      roles: []
    }
    this.userUpdateService.updateUser(updateUser);
  }
}
