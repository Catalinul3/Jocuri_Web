import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { UpcomingGamesComponent } from './upcoming-games/upcoming-games.component';
import { SearchPageComponent } from './search-page/search-page.component';

const routes: Routes = [{
  path:"login",
  component:LoginComponent
},
{
  path:"register",
  component:RegisterComponent
},
{
  path:"home",
  component:HomeComponent
},
{
  path:"upcoming",
  component:UpcomingGamesComponent
},
{
  path:"search",
  component:SearchPageComponent
},
{
  path:"**",redirectTo:"/login",pathMatch:"full"
},
{
  path:"",redirectTo:"/login",pathMatch:"full"
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents=[LoginComponent,RegisterComponent,HomeComponent]
