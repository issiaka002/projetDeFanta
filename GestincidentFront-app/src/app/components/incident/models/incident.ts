//import { Environ } from 'src/app/environ/environ/models/environ';
import { Environ } from '../../environ/models/environ';
import { Logiciel } from '../../logiciel/models/logiciel';
import { AppEnv } from './app-env';
import { Resolution } from "./resolution";
//import { Logiciel } from 'src/app/logiciel/logiciel/models/logiciel';

export interface Incident {
  idInc:number,
 // codeInc:String,
  libelleInc:string,
  environnement:Environ,
  logiciel:Logiciel,
  resolution: string
}
