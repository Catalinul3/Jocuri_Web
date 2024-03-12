import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthentificationService } from '../authentification.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {
  loginForm:FormGroup;
  email = new FormControl('', [Validators.required, Validators.email]);
  password=new FormControl('',[Validators.required,Validators.minLength(1)]);
 
  constructor(private formBuilder:FormBuilder,private authentificationService:AuthentificationService,private router:Router){
    this.loginForm = this.formBuilder.group({
      email: this.email,
      password: this.password,
    });}
getErrorMessage() {
  if (this.email.hasError('required')) {
    return 'You must enter a value';
  }

  return this.email.hasError('email') ? 'Not a valid email' : '';
}
ngOnInit(): void {}
 hide=true;
 hideMethod()
 {
    this.hide=!this.hide;
 }
 loginValidation=false;
 onsubmit()
 {
    
  console.log(this.loginForm.value);
   this.authentificationService.login(this.loginForm.value.email,this.loginForm.value.password)
   .subscribe(response=>{
    console.log(response);
    this.loginValidation=true;
    alert("Login successful");
    this.router.navigate(['/home']);
   },
   error=>{console.error(error);
           alert("Login failed");
    
 });
}}
