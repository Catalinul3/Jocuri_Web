export class Game {
    id:string='';
   title:string='';
     background:string='';
     description:string='';
    rating:number=0;
     poster:string='';
    genre:Genre=Genre.Action;
    pg:number=0;
    year:number=0;
    name:string='';
}
export enum Genre{
  Action='Action',
  Horror='Horror',
  Fantasy='Fantasy',
  SuperHeroes='SuperHeroes',
  Fighting='Fighting',
  Sport='Sport',
  Sandbox='Sandbox',
  Racing='Racing',
  Simulation='Simulation',
  RPG='RPG',
  Strategy='Strategy',
  Western='Western',
}
