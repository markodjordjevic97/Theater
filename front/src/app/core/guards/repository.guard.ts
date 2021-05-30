import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthRepository implements CanActivate {

  constructor(private router: Router) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const user =  JSON.parse(localStorage.getItem('USER_DATA')).username;
    if (user === 'admin') {
      return true;
    }
    this.router.navigate(['/']);
    return false;
  }
}
