import { AuthService } from 'src/app/shared/services/Auth.service';
import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
} from '@angular/common/http';
import { Observable } from 'rxjs';

const TOKEN_HEADER_KEY = 'Authorization';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private authService: AuthService) {}

  intercept(
    req: HttpRequest<unknown>,
    next: HttpHandler
  ): Observable<HttpEvent<unknown>> {
    const user = this.authService.currentUserValue;
    if (user && user.accessToken) {
      req = req.clone({
        headers: req.headers.set(
          TOKEN_HEADER_KEY,
          'Bearer ' + user.accessToken
        ),
      });
    }
    return next.handle(req);
  }
}
