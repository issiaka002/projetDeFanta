import { Component, OnInit } from '@angular/core';
import { Logiciel } from '../models/logiciel';
import { Rex } from '../models/rex';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/service/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logiciel',
  templateUrl: './logiciel.component.html',
  styleUrls: ['./logiciel.component.css']
})
export class LogicielComponent implements OnInit{
  materiels: Logiciel[] = [];
  rexList : Rex[] = [];
  mat! : Logiciel;
  myFormenv! : FormGroup;
  //mat! : Environ
  constructor(
    private service: AuthService,
    private fb: FormBuilder,
    private router: Router
  ) { }

  ngOnInit(): void {

    this.myFormenv = this.fb.group({

      idApp : 0,
      libelleApp:['', Validators.required],
      descriptionApp:['', Validators.required],
      rex:['', Validators.required]




      })
    //getAllMateriel(){
      this.service.listLogiciel().subscribe((response : any) => {
        this.materiels = response;
        //console.log('jj' + this.materiels);

    });

      this.service.listRex().subscribe((data : any) => {
        this.rexList = data;
        console.log(this.rexList);
      });








  }
  chargeData(appl : Logiciel){
    this.mat = appl;
    this.myFormenv.patchValue({
      idEnv: appl.idApp,
      libelleApp: appl.libelleApp,
      descriptionApp: appl.descriptionApp,
      rex: appl.rex.idRex




    });
  }
  delete(materiel: Logiciel){

    this.service.deleteLogiciel(materiel.idApp).subscribe({
      next : data => {
        //console.log(data);
       // alert("succes")
        window.location.reload();
      },
      error : error => {
        console.log(error)
        alert("error")
      }
    });


  }
  edit(){
    this.service.updateLogiciel(this.myFormenv.value).subscribe({
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
