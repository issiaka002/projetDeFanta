import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';
import { Environ } from '../models/environ';
import { AppComponent } from 'src/app/app.component';


@Component({
  selector: 'app-environ',
  templateUrl: './environ.component.html',
  styleUrls: ['./environ.component.css']
})
export class EnvironComponent implements OnInit{
  materiels: Environ[] = [];
  // rex : Rex[] = [];
  myFormenv! : FormGroup;
  mat! : Environ;

  constructor(
    private service: AuthService,
    private fb: FormBuilder,
    private router: Router,
    private appComponent:AppComponent,
  ) { }

  ngOnInit(): void {
    this.appComponent.routeTitle = "Liste des environnements"


    this.myFormenv = this.fb.group({

      idEnv : 0,
      libelleEnv:['', Validators.required]



      })


    //getAllMateriel(){
      this.service.listEnv().subscribe((response : any) => {
        console.log('responsse' + response)
        this.materiels = response;
        console.log('rree'+ this.materiels);


    });
    //getRex
    // this.fonctionRexService.getRex().subscribe((data : any) => {
    //   this.rex = data;
    //   console.log(this.rex);
    //})

  //}




  }

  chargeData(envp : Environ){
    this.mat = envp;
    this.myFormenv.patchValue({
      idEnv: envp.idEnv,
      libelleEnv: envp.libelleEnv



    });
  }
  delete(materiel:Environ){
    let conf = confirm("Are you sure?");
    if(!conf) return;
    this.service.deleteEnv(materiel.idEnv).subscribe({
      next : data => {
        //console.log(data);
        //alert("succes")
        window.location.reload();
      },
      error : error => {
        console.log(error)
        alert("error")
      }
    });


  }

  edit(){
    this.service.updateEnv(this.myFormenv.value).subscribe({
      next : data1 => {
        console.log(data1);
        alert("succes")
        //console.log(data1)
        window.location.reload();
      },
      error : error => {
        console.log(error)
        alert("error")
      }
    });


}
}
