import { Component, Input, OnInit } from '@angular/core';
import { GameServiceService } from '../game-service.service';
import { Game } from '../game';

@Component({
  selector: 'app-search-page',
  templateUrl: './search-page.component.html',
  styleUrl: './search-page.component.css'
})
export class SearchPageComponent  implements OnInit{
  searchResults:Game[]=[];
  allGames:Game[]=[];
  constructor(private gameService:GameServiceService){}
  ngOnInit(): void {
    
  }
  search()
  { this.gameService.searchGames(this.searchTerm)
    .subscribe(
      data=>{
        this.searchResults=data;
        console.log(this.searchResults);
        console.log(this.searchTerm);
      },
      error=>{
        console.log(error);
      }
      );
      this.gameService.getAllGames().subscribe(
        data=>{
          this.allGames=data;
        },
        error=>{
          console.log("error");
        });
      

  }

searchTerm:string='';
}
