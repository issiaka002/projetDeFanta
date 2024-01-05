package ci.gs2e.Gestion_Incidents.Controller;

import ci.gs2e.Gestion_Incidents.Modele.Environnement;
import ci.gs2e.Gestion_Incidents.Modele.Logiciel;
import ci.gs2e.Gestion_Incidents.Service.Application.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.SSLEngineResult;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/logiciel")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@AllArgsConstructor
public class ApplicationController {
    @Autowired

    ApplicationService applicationService;
    @PostMapping
    public ResponseEntity<Logiciel> create(@RequestBody Logiciel application){

        return new ResponseEntity<>(applicationService.create(application), HttpStatus.CREATED);
    }
    @PutMapping()
    public ResponseEntity<Logiciel> edit( @RequestBody Logiciel app){

        return new ResponseEntity<Logiciel>(applicationService.edit(app), HttpStatus.OK);
    }
    @DeleteMapping("/{idApp}")
    public void delete(@PathVariable("idApp") int idApp){
        applicationService.delete(idApp);

    }
    @GetMapping
    public ResponseEntity<List<Logiciel>> getAll(){
        return new ResponseEntity<>(applicationService.listAll(),HttpStatus.OK);
    }

    @GetMapping("/recherche")
    public  ResponseEntity<Optional<Logiciel>> search(@RequestParam(name = "keyword") String libelleApp){
        return  new ResponseEntity<Optional<Logiciel>>(applicationService.listByLibelle(libelleApp),HttpStatus.OK);
    }

}
