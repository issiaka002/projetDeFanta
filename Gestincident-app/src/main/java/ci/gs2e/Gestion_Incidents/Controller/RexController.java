package ci.gs2e.Gestion_Incidents.Controller;

import ci.gs2e.Gestion_Incidents.Modele.Environnement;
import ci.gs2e.Gestion_Incidents.Modele.Rex;
import ci.gs2e.Gestion_Incidents.Modele.RexPage;
import ci.gs2e.Gestion_Incidents.Modele.RexSearchCriteria;
import ci.gs2e.Gestion_Incidents.Service.Rex.RexService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
@RequestMapping("/v1/rex")
public class RexController {
    @Autowired
   private RexService rexService;
//@PreAuthorize("hasAuthority('SCOPE8uSER')")
    /* @GetMapping
    public ResponseEntity<Page<Rex>> getRex(RexPage rexPage, RexSearchCriteria rexSearchCriteria){
        return new ResponseEntity<>(rexService.getRex(rexPage,rexSearchCriteria),
                    HttpStatus.OK);
    }

     */



    @GetMapping
    public ResponseEntity<List<Rex>> getAll(){

       return new ResponseEntity<>(rexService.listAll(), HttpStatus.OK);
     }


    @PostMapping
    public ResponseEntity<Rex> create(@RequestBody Rex rex){

        return new ResponseEntity<Rex>(rexService.create(rex), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Rex> edit(@RequestBody Rex rex){

        return new ResponseEntity<Rex>(rexService.edit(rex), HttpStatus.OK);
    }

    @DeleteMapping("/{idRex}")
    public void delete(@PathVariable("idRex") int idRex){
        rexService.delete(idRex);


    }


    @GetMapping("/{idRex}")
    public ResponseEntity<Optional<Rex>> getById(@PathVariable("idRex") int idRex){
        return new ResponseEntity<Optional<Rex>>(rexService.findById(idRex), HttpStatus.OK);
    }

    //getbynom&prenom
    @GetMapping("/{nom}")
    public ResponseEntity<List<Rex>> getByNom(@PathVariable("keyword") String nom){
        return new ResponseEntity<List<Rex>>(rexService.searchRex(nom), HttpStatus.OK);
    }

}
