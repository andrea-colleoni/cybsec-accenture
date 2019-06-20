import { Component } from '@angular/core';
import { Prodotto } from './prodotto';
import { ProdottiService } from './prodotti.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'prodotti';
  prodotti: Prodotto[];

  constructor(
    public ps: ProdottiService
  ) {
  }
}
