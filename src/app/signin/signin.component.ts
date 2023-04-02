import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserServiceService } from '../service/user-service.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent {

  email!:String

  constructor(private router:Router,private userService:UserServiceService) {}

  signinForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', Validators.required)
  });

  onSubmit() {
    if(this.signinForm.valid)
    {
      this.userService.signinUser(this.signinForm.value).subscribe(data => {
        if(data)
        {
          localStorage.setItem("user","userToken")
          this.router.navigateByUrl("/photos")
        }
        else
        {
          alert("user does not exist")
        }
      },err => {alert("user does not exist")})
    }
    
  }
}
