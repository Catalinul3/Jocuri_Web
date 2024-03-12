import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthentificationService } from '../authentification.service';
import { Router } from '@angular/router';
import { User } from '../user';

@Component({
  selector: './app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent implements OnInit {
 
  ngOnInit(): void {
   
  }
  registerForm:FormGroup;
  name=new FormControl('',[Validators.required]);
  email=new FormControl('',[Validators.required,Validators.email]);
  password=new FormControl('',[Validators.required,Validators.minLength(3)]);
  confirmPassword=new FormControl('',[Validators.required,Validators.minLength(3)]);
 
  constructor(private formBuilder:FormBuilder,private authentificationService:AuthentificationService, private router:Router)
  {
    this.registerForm=new FormGroup({
      name:this.name,
      email:this.email,
      password:this.password,
      confirmPassword:this.confirmPassword
    })

   
  }
 
hideMethod() {
  this.hide=!this.hide;
}
hideConfirmMethod() {
  this.hideConfirm=!this.hideConfirm;
}
hideConfirm=true;
hide=true;
getErrorMessage() {
  if (this.email.hasError('required')) {
    return 'You must enter a value';
  }

  return this.email.hasError('email') ? 'Not a valid email' : '';
}
registerValidation=false;
onsubmit()
{
  console.log(this.registerForm.value);
  if(this.registerForm.value.password==this.registerForm.value.confirmPassword)
  {
    
    this.authentificationService.registerUser(this.registerForm.value)
    .subscribe(response=>{console.log(response);
      this.registerValidation=true;
    alert("Register successful");
    this.router.navigate(['/login']);
 
  },
  error=>{console.error(error);alert("Password and confirm password must be the same");
});
}}
onReset()
{
  this.registerForm.reset();
}}
