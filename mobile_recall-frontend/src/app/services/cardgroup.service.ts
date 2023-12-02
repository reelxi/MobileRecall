import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CardGroup} from "./types";

@Injectable({
  providedIn: 'root'
})
export class CardGroupService {

  url: string = "http://localhost:8080/cardGroup";

  constructor(private httpClient: HttpClient) {
  }

  getAllCardGroups(): Observable<CardGroup[]> {
    return this.httpClient.get<CardGroup[]>(this.url);
  }

  //getCardGroupById()

  //getCardGroupsByUserId()

  saveCardGroups(name: string | null): void {
    this.httpClient.post(this.url, name).subscribe();
  }

}
