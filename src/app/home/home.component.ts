import { Component, OnInit } from '@angular/core';
import { GameServiceService } from '../game-service.service';
import { Game } from '../game';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {
  games:Game[]=[];
constructor(private gameService:GameServiceService){}
//   images=[
//   {src:"/assets/spiderman.jpg", alt:"Spiderman"},
//   {src:"/assets/cyberpunk.jpg", alt:"Cyberpunk 2077 nackground"}
//   ,{src:"/assets/gta4-background.jpg", alt:"GTA 4 background"}

// ]
// imagesPoster=[{src:"/assets/spider-man-poster.jpeg", alt:"Spiderman"},
// {
//   src:"/assets/cyberpunk-poster.jpg", alt:"Cyberpunk 2077"
// },
// {
//   src:"/assets/gta_poster.png", alt:"GTA 4"

// }]

// titlesImages=[{src:"/assets/spiderman-title.png", alt:"Spiderman"},
//   {src:"/assets/cyberpunk-2077-title.png", alt:"Cyberpunk 2077"},
//   {src:"/assets/GTA_IV_logo.png", alt:"GTA 4"}];
ngOnInit(): void {
  this.gameService.getAllGames()
  .subscribe(
    data=>{
      this.games=data;
    },
    error=>{
      console.log(error);
    }
    );
  
}
showCarousel = true;
showNavigationIndex=false;
onItemChange($event: any):void{
  console.log($event);
}

next=false;
prev=false;
activeIndex:number=0;
activeTitle:number=0;
activeBackground:number=0;
onNextClick():void{
  this.next=true;
  this.activeIndex = (this.activeIndex + 1) % this.games.length;
  this.activeTitle=(this.activeTitle+1)%this.games.length;
  this.activeBackground=(this.activeBackground+1)%this.games.length;
  console.log(this.activeIndex);
  console.log(this.games[this.activeIndex].background);
  
}
onPrevClick():void{
  if(this.activeIndex>0&&this.activeTitle>0&&this.activeBackground>0)
  this.activeIndex = (this.activeIndex - 1 + this.games.length) % this.games.length;
  this.activeTitle=(this.activeTitle - 1 + this.games.length) % this.games.length;
  this.activeBackground=(this.activeBackground-1 +this.games.length)%this.games.length;
}
}