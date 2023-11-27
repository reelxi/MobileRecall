import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  backendApi: string = "http://localhost:8080";
  controllerPath: string = "/user";

  constructor(private httpClient: HttpClient) {}

  //getUsers()
  //getUserById()
  //saveUser()
}
