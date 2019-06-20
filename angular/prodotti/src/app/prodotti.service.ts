import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Prodotto } from './prodotto';
import { HttpClient } from '@angular/common/http';
import { map, take } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProdottiService {

  constructor(
    private http: HttpClient,
  ) { }

  all(): Observable<Prodotto[]> {
    return this.http.get<any>('http://localhost:8080/prodottoes').pipe(
      map(p => p._embedded.prodottoes)
    );
  }
}
