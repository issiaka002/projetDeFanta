package ci.gs2e.Gestion_Incidents.Controller;

//import ci.gs2e.Gestion_Incidents.Modele.Logiciel;
import ci.gs2e.Gestion_Incidents.Modele.Environnement;
import ci.gs2e.Gestion_Incidents.Repository.EnvironnementRepository;
import ci.gs2e.Gestion_Incidents.Service.Environnement.EnvironnementService;
//import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/v1/environnement")
//@AllArgsConstructor
public class EnvironnementController {
    @Autowired
    EnvironnementService environnementService;

    @Autowired
    EnvironnementRepository environnementRepository;

    @GetMapping
   //@PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity <List<Environnement>> getAll(){
        return new ResponseEntity<>(environnementService.listAll(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Environnement> create(@RequestBody Environnement env){

        return new ResponseEntity<Environnement>(environnementService.create(env), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Environnement> edit(@RequestBody Environnement env){

        return new ResponseEntity<Environnement>(environnementService.edit(env), HttpStatus.OK);
    }
    @DeleteMapping("/{idEnv}")
    public void delete(@PathVariable("idEnv") int idEnv){
        environnementService.delete(idEnv);

    }
/*
    @GetMapping("/tutorials")
    public ResponseEntity<Map<String, Object>> getAllTutorials(
            @RequestParam(required = false) String title,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {

        try {
            List<Environnement> tutorials = new ArrayList<Environnement>();
            Pageable paging = PageRequest.of(page, size);

            Page<Environnement> pageTuts;
            if (title == null)
                pageTuts = environnementRepository.findAll(paging);
            else
                pageTuts = environnementRepository.findByLibelleContaining(title, paging);

            tutorials = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("tutorials", tutorials);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

 */
/*
    @GetMapping("/env/{pageNumber}/{pageSize}")
    public List < Environnement > getEnv(@PathVariable Integer pageNumber, @PathVariable Integer pageSize) {
        Page < Environnement > data = environnementService.getEnvironnementPagination(pageNumber, pageSize, null);
        return data.getContent();
    }
    @GetMapping("/env/{pageNumber}/{pageSize}/{sort}")
    public List < Environnement > getEnv(@PathVariable Integer pageNumber, @PathVariable Integer pageSize, @PathVariable String sort) {
        Page < Environnement > data = environnementService.getEnvironnementPagination(pageNumber, pageSize, sort);
        return data.getContent();
    }

 */

    @GetMapping("/recherche")
    public  ResponseEntity<Optional<Environnement>> search(@RequestParam(name = "keyword") String libelleEnv){
        return  new ResponseEntity<Optional<Environnement>>(environnementService.listByLibelle(libelleEnv),HttpStatus.OK);
    }

}
