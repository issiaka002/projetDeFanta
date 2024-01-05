package ci.gs2e.Gestion_Incidents.Controller;

import ci.gs2e.Gestion_Incidents.Modele.AppEnvironnement;
import ci.gs2e.Gestion_Incidents.Modele.Logiciel;
import ci.gs2e.Gestion_Incidents.Service.AppEnv.AppEnvService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/envapp")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@AllArgsConstructor
public class AppEnvController {
    AppEnvService appEnvService;
    @PostMapping
    public ResponseEntity<AppEnvironnement> create(@RequestBody AppEnvironnement appEnvironnement){

        return new ResponseEntity<AppEnvironnement>(appEnvService.create(appEnvironnement), HttpStatus.CREATED);
    }
    @PutMapping("/{idApp}")
    public ResponseEntity<AppEnvironnement> edit(@RequestBody AppEnvironnement appEnv){

        return new ResponseEntity<AppEnvironnement>(appEnvService.edit(appEnv), HttpStatus.UPGRADE_REQUIRED);
    }
    @DeleteMapping("/{idAppEnv}")
    public void delete(@PathVariable("idAppEnv") int idAppEnv){
        appEnvService.delete(idAppEnv);

    }
    @GetMapping
    public ResponseEntity<List<AppEnvironnement>> getAll(){
        return new ResponseEntity<>(appEnvService.listAll(),HttpStatus.OK);
    }

}
