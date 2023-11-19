import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CardGroupService {

  url: string = "http://localhost:8080/cardGroup";

  constructor(private httpClient: HttpClient) {}

  getCardGroups(): Observable<CardGroup[]> {
    return this.httpClient.get<CardGroup[]>(this.url);
  }

}
