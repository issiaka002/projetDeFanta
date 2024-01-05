import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const BASE_URL = ['http://localhost:8070/']

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private http: HttpClient
  ) { }

  signup(signupRequest: any): Observable<any> {
    return this.http.post(BASE_URL + "sign-up", signupRequest)
  }

  login(loginRequest: any): Observable<any> {
    return this.http.post(BASE_URL + "authenticate", loginRequest)
  }

  hello(): Observable<any> {
    return this.http.get(BASE_URL + 'v1/hello', {headers : this.httpHeader()});
  }

  createRex(rexRequest: any): Observable<any> {
    return this.http.post(BASE_URL + "v1/rex", rexRequest, {headers : this.httpHeader()});
  }

  listRex(): Observable<any> {
    return this.http.get(BASE_URL + "v1/rex",  {headers : this.httpHeader()});
  }
  updateRex(rexRequest: any): Observable<any> {
    return this.http.put(BASE_URL + "v1/rex", rexRequest, {headers : this.httpHeader()});
  }
  deleteRex(id:number): Observable<any> {
    return this.http.delete(`${BASE_URL}v1/rex/${id}`, {headers : this.httpHeader()});
  }

  createLogiciel(logicielRequest: any): Observable<any> {
    return this.http.post(BASE_URL + "v1/logiciel", logicielRequest,  {headers : this.httpHeader()})
  }

  listLogiciel(): Observable<any> {
    return this.http.get(BASE_URL + "v1/logiciel",  {headers : this.httpHeader()});
  }
  updateLogiciel(logicielRequest: any): Observable<any> {
    return this.http.put(BASE_URL + "v1/logiciel", logicielRequest, {headers : this.httpHeader()});
  }
  deleteLogiciel(id:number): Observable<any> {
    return this.http.delete(`${BASE_URL}v1/logiciel/${id}`, {headers : this.httpHeader()})
  }

  postFile(fileRequest : any) {
    return this.http.post(BASE_URL + "v1/incident",fileRequest,{headers : this.httpHeaderforFile()});
  }

  listIncident(): Observable<any> {
    return this.http.get(BASE_URL + "v1/incident", {headers : this.httpHeader()});
  }

  createEnv(envRequest: any): Observable<any> {
    return this.http.post(BASE_URL + "v1/environnement", envRequest,{headers : this.httpHeader()})
  }

  listEnv(): Observable<any> {
    return this.http.get(BASE_URL + "v1/environnement",  {headers : this.httpHeader()});
  }
  updateEnv(envRequest: any): Observable<any> {
    return this.http.put(BASE_URL + "v1/environnement", envRequest, {headers : this.httpHeader()})
  }
  deleteEnv(id:number): Observable<any> {
    return this.http.delete(`${BASE_URL}v1/environnement/${id}`,{headers : this.httpHeader()})
  }

  searchEnv(keyword : string){
       return this.http.get(BASE_URL+'v1/environnement/recherche?keyword='+keyword, {headers : this.httpHeader()});
     }
     searchApp(keyword : string){
      return this.http.get(BASE_URL+'v1/logiciel/recherche?keyword='+keyword, {headers : this.httpHeader()})
    }
    searchRex(keyword : string){
      return this.http.get(BASE_URL+'v1/rex/recherche?keyword='+keyword, {headers : this.httpHeader()})
    }




  private createAuthorizationHeader() {
    const jwtToken = localStorage.getItem('JWT');
    if (jwtToken) {
      return new HttpHeaders().set(
        'Authorization', 'Bearer ' + jwtToken
      )
    } else {
      console.log("JWT token not found in the Local Storage");
    }
    return null;
  }

  httpHeader(){
    const jwtToken = localStorage.getItem('JWT');
        return new HttpHeaders({
          'Content-Type': 'application/json',
          'Access-Control-Allow-Origin': '*',
          'Access-Control-Allow-Methods': 'POST, GET, OPTIONS, PUT,DELETE',
          'Accept': '*/*',
          'Authorization': 'Bearer ' + jwtToken
        });

      }

      httpHeaderforFile() {
        const jwtToken = localStorage.getItem('JWT');
        return new HttpHeaders({
          //'Content-Type': 'undefined',
          'Access-Control-Allow-Origin': '*',
          'Access-Control-Allow-Methods': 'POST, GET, OPTIONS, PUT,DELETE',
          'Accept': '*/*',
          'Authorization': 'Bearer ' + jwtToken
        });
      }

}
