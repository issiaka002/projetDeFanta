import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/auth/login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { SignupComponent } from './components/signup/signup/signup.component';
import { RexComponent } from './components/rex/rex/rex.component';
import { CreaterexComponent } from './components/rex/create/createrex/createrex.component';
import { EnvironComponent } from './components/environ/environ/environ.component';
import { CreateenvironComponent } from './components/environ/create/createenviron/createenviron.component';
import { LogicielComponent } from './components/logiciel/logiciel/logiciel.component';
import { CreatelogicielComponent } from './components/logiciel/create/createlogiciel/createlogiciel.component';
import { IncidentComponent } from './components/incident/incident/incident.component';
import { CreateincidentComponent } from './components/incident/create/createincident/createincident.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    SignupComponent,
    RexComponent,
    CreaterexComponent,
    EnvironComponent,
    CreateenvironComponent,
    LogicielComponent,
    CreatelogicielComponent,
    IncidentComponent,
    CreateincidentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    CommonModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
