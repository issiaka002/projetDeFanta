package ci.gs2e.Gestion_Incidents.Controller;

import ci.gs2e.Gestion_Incidents.Modele.Environnement;
import ci.gs2e.Gestion_Incidents.Modele.Resolution;
import ci.gs2e.Gestion_Incidents.Service.Resolution.ResolutionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
@RequestMapping(("v1/resolution"))
public class ResolutionController {
    ResolutionService resolutionService;
    @GetMapping
    public ResponseEntity<List<Resolution>> getAll(){
        return new ResponseEntity<>(resolutionService.listAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Resolution> create(@RequestBody Resolution resolution){

        return new ResponseEntity<Resolution>(resolutionService.create(resolution), HttpStatus.CREATED);
    }
    @PutMapping("/{idReso}")
    public ResponseEntity<Resolution> edit(@RequestBody Resolution reso){

        return new ResponseEntity<Resolution>(resolutionService.edit(reso), HttpStatus.UPGRADE_REQUIRED);
    }
    @DeleteMapping("/{idReso}")
    public void delete(@PathVariable("idReso") int idReso){
        resolutionService.delete(idReso);

    }
}
