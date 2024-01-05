import { Component, OnInit } from '@angular/core';
import { Environ } from '../../models/environ';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/service/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-createenviron',
  templateUrl: './createenviron.component.html',
  styleUrls: ['./createenviron.component.css']
})
export class CreateenvironComponent implements OnInit{
  mat : Environ[] = [];
  //rexp : Rex[] = [];
  myFormenv! : FormGroup;
  searchFormGroup!: FormGroup;
  customers! :any;
  errorMessage!: string;

  constructor(
    private service: AuthService,
    private fb: FormBuilder,
    private router: Router
  ) { }

  ngOnInit(): void {

    this.myFormenv = this.fb.group({

      // codeEnv:['', Validators.required],
      libelleEnv:['', Validators.required],


      })

      // this.searchFormGroup=this.fb.group({
      // keyword : this.fb.control("")
      // });
      // this.Search();

      // this.rex.getRex().subscribe((donnees : any) => {
      //   this.rexp = donnees;
      //   console.log(donnees)


    //})
    this.searchFormGroup=this.fb.group({
      keyword : this.fb.control("")
    });
    this.search();



  }
  search(){
  let kw=this.searchFormGroup?.value.keyword;
  console.log(kw + JSON.stringify(this.customers) + JSON.stringify(this.searchFormGroup?.value.keyword) + JSON.stringify(this.searchFormGroup?.value))
    this.service.searchEnv(kw).subscribe(
      {
        next : data2 => {
          this.customers = JSON.stringify(data2)
          console.log(data2);

         // window.location.reload();


        },
        error : error => {
          console.log(error)

        }
      });

    // pipe(
    //   catchError(err => {
    //     this.errorMessage=err.message;
    //     return throwError(err);
    //   })
    // );
}

  save(){
    if(this.myFormenv.invalid){
      alert("Veuillez remplir correctement les champs");
    }
    else{
      this.service.createEnv(this.myFormenv.value).subscribe({
        next : data => {
          console.log(data);
         // alert("succes")
          window.location.reload();


        },
        error : error => {
          console.log(error)
          alert("error")
        }
      });
      console.log(this.myFormenv.value)
    }
  }

}
