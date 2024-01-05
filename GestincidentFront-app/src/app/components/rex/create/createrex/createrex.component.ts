import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-createrex',
  templateUrl: './createrex.component.html',
  styleUrls: ['./createrex.component.css']
})
export class CreaterexComponent implements OnInit{
  myFormenv!: FormGroup;
  constructor(
    private service: AuthService,
    private fb: FormBuilder,
    private router: Router
  ) { }

  ngOnInit() {
    this.myFormenv = this.fb.group({
      nom: ['', Validators.required, Validators.email],
      prenom: ['', Validators.required],
      fonction: ['', Validators.required],
    })
  }
  save() {
    console.log(this.myFormenv.value);
    this.service.createRex(this.myFormenv.value).subscribe((response) => {
      console.log(response);

        window.location.reload();



      },
     error => {
        console.log(error)
        alert("error")



    })
  }




}
