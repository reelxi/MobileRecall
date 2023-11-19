import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CardService {

  url: string = "http://localhost:8080/card";
  cardsOfSelectedCardGroup: Card[];

  constructor(private httpClient: HttpClient) {}

  getCards(): Observable<Card[]> {
    return this.httpClient.get<Card[]>(this.url);
  }

  getCardsByCardGroup(cardGroupID: string): Observable<Card[]> {
    return this.httpClient.get<Card[]>(this.url + "/cardGroup=" + cardGroupID);
  }
}
