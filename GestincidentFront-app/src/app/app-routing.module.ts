import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/auth/login/login.component';
import { SignupComponent } from './components/signup/signup/signup.component';
import { CreaterexComponent } from './components/rex/create/createrex/createrex.component';
import { CreateenvironComponent } from './components/environ/create/createenviron/createenviron.component';
import { CreatelogicielComponent } from './components/logiciel/create/createlogiciel/createlogiciel.component';
import { CreateincidentComponent } from './components/incident/create/createincident/createincident.component';
import { IncidentComponent } from './components/incident/incident/incident.component';

const routes: Routes = [
  {
    path:'home',
    component:HomeComponent
  },
  {
    path:'',
    component:LoginComponent
  },
  {
    path: 'signup',
     component: SignupComponent },
  { path: '', pathMatch: 'full',
   redirectTo: 'login'},
   { path: 'rex', component: CreaterexComponent },
   { path: 'environ', component: CreateenvironComponent },
   { path: 'logiciel', component: CreatelogicielComponent },
   { path: 'createincident', component: CreateincidentComponent },
   { path: 'listIncident', component: IncidentComponent },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
