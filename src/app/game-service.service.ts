import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Game } from './game';

@Injectable({
  providedIn: 'root'
})
export class GameServiceService {

  private usersURL:string;
  constructor(private http:HttpClient) { this.usersURL='http://localhost:8080/game';}
  getAllGames():Observable<Game[]>{
    return this.http.get<Game[]>(this.usersURL+'/getAllGames');
  }
  getUpcomingGames():Observable<Game[]>{
    return this.http.get<Game[]>(this.usersURL+'/getUpcomingGames');
  }
  searchGames(searchTerm:string):Observable<Game[]>{ 
    const params = new HttpParams().set('name', searchTerm);
    return this.http.get<Game[]>(this.usersURL+'/searchGame',{params});
  }
}
