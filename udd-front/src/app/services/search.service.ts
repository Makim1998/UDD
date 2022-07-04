import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { SearchItems } from '../models/searchItems';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  constructor(
    private http: HttpClient) { }

    readonly API_SEARCH: string = `${environment.baseUrl}/${environment.apiSearch}`;


  search(items: SearchItems): Observable<any> {
    return this.http.post(`${this.API_SEARCH}`, items).pipe(map((data: any) => {
      return data;
    }));
  }

  test(): Observable<any> {
    return this.http.get(`${this.API_SEARCH}`).pipe(map((data: any) => {
      return data;
    }));
  }
}
