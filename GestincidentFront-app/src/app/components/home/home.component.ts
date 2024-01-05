import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AppComponent } from 'src/app/app.component';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  public nomAdmin:string="Super admin"
  message!: String;
  constructor(
    private router:Router,
    private appComponent:AppComponent,
    private service: AuthService
  ) {
  }

  public ngOnInit(): void {

    this.appComponent.routeTitle = "Tableau de bord"
    this.appComponent.routeDescription = "Bienvenue, " + this.nomAdmin
    this.hello();
  }

  hello() {
    this.service.hello().subscribe((response) => {
      console.log(response);
      this.message = response.message;
    })
  }

  logout(){
    const jwtToken = localStorage.getItem('JWT');
     localStorage.removeItem('JWT');

    this.router.navigate(['/login']);


  }

}
