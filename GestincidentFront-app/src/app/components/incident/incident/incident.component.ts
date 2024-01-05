import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Environ } from 'src/app/components/environ/models/environ';
import { Logiciel } from 'src/app/components/logiciel/models/logiciel';
import { AuthService } from 'src/app/service/auth.service';
import { Incident } from '../models/incident';


@Component({
  selector: 'app-incident',
  templateUrl: './incident.component.html',
  styleUrls: ['./incident.component.css']
})
export class IncidentComponent implements OnInit{
  mat : Incident[] = [];
  //resol : Resolution[] = [];
  logiciel : Logiciel[] = [];
  environment : Environ[] = [];
  myForm! : FormGroup;

  constructor(
    private service: AuthService,
    private fb: FormBuilder,
    private router: Router
  ) { }
  ngOnInit(): void {


    this.myForm = this.fb.group({

      //codeInc:['', Validators.required],
      //libelleInc:['', Validators.required],
      incident:['', Validators.required],
       logiciel:['', Validators.required],
       environment:['', Validators.required]


      })
      this.service.listLogiciel().subscribe((donnees : any) => {
        this.logiciel = donnees;
        console.log(donnees)


    });

    this.service.listEnv().subscribe((data : any) => {
      this.environment = data;
      console.log(data)


  })
  this.service.listIncident().subscribe((data1 : any) => {
    this.mat = data1;
    console.log(data1)


})
}


}
