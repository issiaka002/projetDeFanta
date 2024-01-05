import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class MainApiService {
  protected _accessToken:string = "";

  constructor(private http:HttpClient) { }
  public rootUrl() {
    return environment.mainApiUrl
  }

  public accessToken():string {
    return this._accessToken;
  }
  public setAccessToken(token:string) {
    this._accessToken = token;
  }
  public clearAccessToken() {
    this._accessToken = "";
  }


}
