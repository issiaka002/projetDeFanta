package ci.gs2e.Gestion_Incidents.Service.Incident;

import ci.gs2e.Gestion_Incidents.Modele.Incident;
import ci.gs2e.Gestion_Incidents.Repository.IncidentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class IncidentServiceImpl implements IncidentService{
    IncidentRepository incidentRepository;
    @Override
    public Incident create(Incident incident) {
        return incidentRepository.save(incident);
    }

    @Override
    public Incident edit(Incident incident) {
        Incident existingIncident = incidentRepository.findById(incident.getIdInc()).orElse(null);
        existingIncident.setLibelleInc(incident.getLibelleInc());
        existingIncident.setResolution(incident.getResolution());
        existingIncident.setLogiciel(incident.getLogiciel());
        existingIncident.setEnvironnement(incident.getEnvironnement());
        existingIncident.setAppEnvironnement(incident.getAppEnvironnement());

        return incidentRepository.save(existingIncident);
    }

    @Override
    public void delete(int idInc) {
        incidentRepository.deleteById(idInc);

    }

    @Override
    public List<Incident> listAll() {

        return incidentRepository.findAll();
    }

    @Override
    public Optional<Incident> findOne(int idInc) {

        return incidentRepository.findById(idInc);
    }

    @Override
    public Incident listByLibelle(Incident incident) {
        return null;
    }
}
