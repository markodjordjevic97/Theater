import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/shared/services/Auth.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss'],
})
export class FooterComponent {

  logUser: any = false;
  
  constructor(private authService: AuthService) {
    if(this.authService.currentUserValue) {
      this.logUser = true;
    }
  }

}
