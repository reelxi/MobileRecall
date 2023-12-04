import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CardGroup} from "./types";

@Injectable({
  providedIn: 'root'
})
export class CardGroupService {

  readonly url: string = "http://localhost:8080/cardGroup";

  constructor(private httpClient: HttpClient) {
  }

  fetchAllCardGroups(): Observable<CardGroup[]> {
    return this.httpClient.get<CardGroup[]>(this.url);
  }

  // TODO: getAllCardGroupsByUserID, also change every invoking of getAllCardGroups() to this method

  createCardGroups(body: string): Observable<CardGroup> {
    return this.httpClient.post<CardGroup>(this.url, body, {headers: {'Content-Type': 'application/json'}});
  }

}
