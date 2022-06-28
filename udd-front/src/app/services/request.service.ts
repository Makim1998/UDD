import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RequestService {

  constructor(
    private http: HttpClient
    ) { }

    readonly API_REQUEST: string = `${environment.baseUrl}/${environment.apiReq}`;


    request(formData: FormData): Observable<any> {
      return this.http.post(`${this.API_REQUEST}`, formData).pipe(map((data: any) => {
        return data;
      }));
    }
}
