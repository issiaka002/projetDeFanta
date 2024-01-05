package ci.gs2e.Gestion_Incidents.Service.Incident;

import ci.gs2e.Gestion_Incidents.Modele.Incident;

import java.util.List;
import java.util.Optional;

public interface IncidentService {
    public Incident create(Incident incident);
    public  Incident edit(Incident incident);
    public void delete(int idInc);
    public List<Incident> listAll();
    public Optional<Incident> findOne(int idInc);
    public Incident listByLibelle(Incident incident);
}
