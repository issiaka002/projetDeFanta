import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AppComponent } from 'src/app/app.component';
import { AuthService } from 'src/app/service/auth.service';
import { User } from './models/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  loginForm!: FormGroup;
  user! : User

  public submitEnabled:boolean=true
  public paramUsername:string=""
  public paramPassword:string=""
  constructor(
    private router:Router,
    private appComponent:AppComponent,
    private service: AuthService,
    private fb: FormBuilder,

  ) {
  }
  public submitRequest():void {
    this.submitEnabled = false
    if(this.paramUsername == "admin" && this.paramPassword == "admin") {
      this.appComponent.showInfo("Vous êtes connecté comme " + this.paramUsername)
      this.router.navigate(['/home'])
    }
    else {
      this.appComponent.showError("Login / Mot de passe incorrect.")
      this.submitEnabled = true
    }


  }

  public ngOnInit(): void {
    this.appComponent.routeTitle = "Authentification"
    this.appComponent.routeDescription = ""

    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
    })
  }
  get f() {
    return this.loginForm.controls;
  }

  login() {
    this.submitEnabled = false
    console.log(this.loginForm.value);
    this.service.login(this.loginForm.value).subscribe((response) => {
      console.log(response);
      if (response.jwtToken) {
        //alert(response.jwtToken);
        const jwtToken = response.jwtToken;
        localStorage.setItem('JWT', jwtToken);
        this.appComponent.showInfo("Vous êtes connecté " )
        this.router.navigate(['/home']);
        //this.loginForm.reset();

      }
      if(this.loginForm.value == ""){
        this.appComponent.showError("Login / Mot de passe incorrect.")
      this.submitEnabled = true
      }
    })
  }



}
