import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import {Card} from "./types";

@Injectable({
  providedIn: 'root'
})
export class CardService {

  backendApi: string = "http://localhost:8080";
  controllerPath: string = "/card";
  cardsOfSelectedCardGroup: Card[];

  constructor(private httpClient: HttpClient) {}

  getAllCards(): Observable<Card[]> {
    return this.httpClient.get<Card[]>(this.backendApi + this.controllerPath);
  }

  //getCardById()

  getCardsByCardGroupId(cardGroupID: string): Observable<Card[]> {
    return this.httpClient.get<Card[]>(this.backendApi + this.controllerPath + "/cardGroup=" + cardGroupID);
  }

  //saveCard()
}
