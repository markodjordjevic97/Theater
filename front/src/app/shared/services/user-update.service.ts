import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from 'src/app/core/models/user.interface';
import { environment } from 'src/environments/environment';
import { NotificationService } from './notification.service';

@Injectable({
  providedIn: 'root'
})
export class UserUpdateService {

  constructor(private http: HttpClient, private notificationService: NotificationService) { }

  updateUser(user: any) {
    const userUpdate = {
      id: user.id,
      username: user.username,
      email: user.email,
      password: user.password
    }
    return this.http.put<User>(environment.API_ENDPOINT + 'user/update', userUpdate).subscribe(
      res => this.notificationService.success('Uspesno ste azurirali podatke !'),
      error => this.notificationService.error('Doslo je do greske. Pokusajte ponovo!')
    );
  }
}
