import { HttpClient } from '@angular/common/http';
import { ThrowStmt } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class PerformancesService {
  constructor(private http: HttpClient) {}

  getPerformances() {
    return this.http.get<Performance[]>(
      environment.API_ENDPOINT + 'performances/get'
    );
  }

  addPerformances(performance: any) {
    const perf = {
      title: performance.title,
      duration: performance.duration,
      description: performance.description,
      writer: {
        id: performance.writer.id,
      },
      type: {
        id: performance.type.id,
      },
    };

    return this.http.post<Performance>(environment.API_ENDPOINT + 'performances/add', perf)
      .subscribe(
        () => console.log(''),
        catchError(() => {
          return of();
        })
      );
  }

  deletePerfomance(performance: any) {
    return this.http.delete<any>(
      environment.API_ENDPOINT + `performances/delete/${performance.id}`
    ).subscribe()
  }

  addWriter(writer: any) {
    return this.http.post<any>(environment.API_ENDPOINT + 'writer/add', writer);
  }

  getWriter() {
    return this.http.get<any>(environment.API_ENDPOINT + 'writer/all');
  }

  addType(type: any) {
    return this.http.post<any>(environment.API_ENDPOINT + 'type/add', type);
  }

  getType() {
    return this.http.get<any>(environment.API_ENDPOINT + 'type/get');
  }
}
