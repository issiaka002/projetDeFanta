import { Component, OnInit } from '@angular/core';
import { Incident } from '../../models/incident';
import { Logiciel } from 'src/app/components/logiciel/models/logiciel';
import { Resolution } from '../../models/resolution';
import { Environ } from 'src/app/components/environ/models/environ';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/service/auth.service';
import { Router } from '@angular/router';
import { PayloadIncident } from '../../models/payload-incident';


@Component({
  selector: 'app-createincident',
  templateUrl: './createincident.component.html',
  styleUrls: ['./createincident.component.css']
})
export class CreateincidentComponent implements OnInit{
  mat: Incident[] = [];
  resol: Resolution[] = [];
  logiciel: Logiciel[] = [];
  environment: Environ[] = [];
  myForm!: FormGroup;
  formData : FormData = new FormData();
  file? : any;

  constructor(
    private service: AuthService,
    private fb: FormBuilder,
    private router: Router
  ) { }

  ngOnInit(): void {

    this.myForm = this.fb.group({

     // codeInc: ['', Validators.required],
      libelleInc: ['', Validators.required],
      resolution: ['', Validators.required],
      logiciel: ['', Validators.required],
      environnement: ['', Validators.required]


    })

    this.service.listLogiciel().subscribe((donnees: any) => {
      this.logiciel = donnees;
      console.log(donnees)


    });

    this.service.listEnv().subscribe((data: any) => {
      this.environment = data;
      console.log(data)


    })



    // })
  }

  onSave() {
    if (this.myForm.invalid) {

      alert("Veuillez remplir correctement les champs");
    }
    else {


      const formData = new FormData();

      console.log(this.myForm);

      let codeInc = this.myForm.get('codeInc')?.value;
      let libelleInc = this.myForm.get('libelleInc')?.value;
      let resolution = this.myForm.get('resolution')?.value;
      let logiciel = this.myForm.get('logiciel')?.value;
      let environnement = this.myForm.get('environnement')?.value;

      let incident: Incident = {
        idInc: 0,

        libelleInc: libelleInc,
        environnement: environnement,
        logiciel: logiciel,
        resolution: ""
      };
      let payloadIncident: PayloadIncident = {
        ploadIncudent: incident,
        document: this.file
      }
      this.formData?.append("libelleInc",libelleInc)
      this.formData?.append("environnement",environnement)
      this.formData?.append("logiciel",logiciel)
      this.formData?.append("resolution",resolution)


      //console.log(payloadIncident)
      //console.log(formData)
      this.formData.forEach((key,value)=>{
        console.log(key, value)})


      this.service.postFile(this.formData).subscribe({



        next: data => {
          console.log(data)
          alert("succes")
          window.location.reload();



        },
        error: error => {
          console.log(error)
          alert("error: veuillez uploader un fichier dont la taille est inferieur à 1000 ")
        }
      });
      console.log(this.myForm.value)
    }

  }

 public onFileSelected(ev:any) {
     this.file = ev.target.files[0];

    if (this.file) {


      this.formData.append("document", this.file);
      console.log(this.file)
    }

  }




}
