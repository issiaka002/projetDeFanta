import { Environ } from "../../environ/models/environ";
import { Logiciel } from "../../logiciel/models/logiciel";

export interface AppEnv {
  idAppEnv:number,
  codeAppEnv:string,
  logiciel:Logiciel,
  environ:Environ
}
