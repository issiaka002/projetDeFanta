package ci.gs2e.Gestion_Incidents.Controller;

import ci.gs2e.Gestion_Incidents.Modele.Environnement;
import ci.gs2e.Gestion_Incidents.Modele.Incident;
import ci.gs2e.Gestion_Incidents.Modele.Logiciel;
import ci.gs2e.Gestion_Incidents.Modele.Pload.IncidentPayload;
import ci.gs2e.Gestion_Incidents.Service.Incident.IncidentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
@RequestMapping("/v1/incident")

public class IncidentController {

    @Autowired
   IncidentService incidentService;

    private final Path root = Paths.get("Document");

    @GetMapping
    public ResponseEntity<List<Incident>> getAll(){
        return new ResponseEntity<>(incidentService.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{idInc}")
    public ResponseEntity<Optional<Incident>> getById(@PathVariable("idInc") int idInc){

        return new ResponseEntity<Optional<Incident>>(incidentService.findOne(idInc), HttpStatus.OK);
    }
    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Incident> create(@ModelAttribute IncidentPayload incidentPayload){
        Incident incident= new Incident();
        Logiciel logiciel = Logiciel.builder().idApp(incidentPayload.getLogiciel()).build();
        Environnement environnement = Environnement.builder().idEnv(incidentPayload.getEnvironnement()).build();
        incident.setLogiciel(logiciel);
        incident.setEnvironnement(environnement);
        incident.setLibelleInc(incidentPayload.getLibelleInc());
        try {


        Path filepath =  write(incidentPayload.getDocument(),this.root.getFileName());

            incident.setResolution(filepath.getFileName().toString());
           // Files.copy(file.toPath(), this.root.getFileName(), StandardCopyOption.REPLACE_EXISTING);


        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file of that name already exists.");

            }

            throw new RuntimeException(e.getMessage());
        }


        System.out.println(incident);
        return new ResponseEntity<Incident>(incidentService.create(incident), HttpStatus.CREATED);
    }
    @PutMapping("/{idInc}")
    public ResponseEntity<Incident> edit(@RequestBody Incident inc){

        return new ResponseEntity<Incident>(incidentService.edit(inc), HttpStatus.UPGRADE_REQUIRED);
    }
    @DeleteMapping("/{idInc}")
    public void delete(@PathVariable("idInc") int idInc){
        incidentService.delete(idInc);

    }
    public Path write(MultipartFile file, Path dir) throws IOException {
        Path filepath = Paths.get(dir.toString(), file.getOriginalFilename());

        try (OutputStream os = Files.newOutputStream(filepath)) {
            os.write(file.getBytes());
        }
        return filepath;
    }
}


