import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';
import { Rex } from '../../models/rex';

@Component({
  selector: 'app-createlogiciel',
  templateUrl: './createlogiciel.component.html',
  styleUrls: ['./createlogiciel.component.css']
})
export class CreatelogicielComponent implements OnInit{
rexp : Rex[] =[]
  myForm!: FormGroup;
  constructor(
    private service: AuthService,
    private fb: FormBuilder,
    private router: Router
  ) { }
  ngOnInit(): void {

    this.myForm = this.fb.group({

     // codeApp:['', Validators.required],
      libelleApp:['', Validators.required],
      descriptionApp:['', Validators.required],
       rex:['', Validators.required]


      })

      this.service.listRex().subscribe((donnees : any) => {
        this.rexp = donnees;
        console.log(donnees)


    })

}
save() {
  if(this.myForm.invalid){
    alert("Veuillez remplir correctement les champs");
  }
  else{
    //let codeApp = this.myForm.get('codeApp')?.value;
    let libelleApp = this.myForm.get('libelleApp')?.value;
    let descriptionApp = this.myForm.get('descriptionApp')?.value;
    let rex = this.myForm.get('rex')?.value;
    this.service.createLogiciel({libelleApp:libelleApp,descriptionApp:descriptionApp,rex:{"idRex":rex}}).subscribe({



      next : data => {
        console.log(data)
        //alert("succes")
        window.location.reload();



      },
      error : error => {
        console.log(error)
        alert("error")
      }
    });
    console.log(this.myForm.value)
  }
}


}
