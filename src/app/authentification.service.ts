import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthentificationService {
  private usersURL:string;
  constructor(private http:HttpClient) { this.usersURL='http://localhost:8080/users';}
  registerUser(user:User):Observable<User>{
    return this.http.post<User>(this.usersURL+'/registerUser',user);
  }
  login(email:string,password:string):Observable<any>{
    return this.http.get<any>(this.usersURL+'/loginUser',{params:{email:email,password:password}});
  }
}
