package ci.gs2e.Gestion_Incidents.Service.Resolution;

import ci.gs2e.Gestion_Incidents.Modele.Resolution;

import java.util.List;

public interface ResolutionService {
    public Resolution create(Resolution resolution);
    public  Resolution edit(Resolution resolution);
    public void delete(int idReso);
    public List<Resolution> listAll();
    public Resolution listByLibelle(Resolution resolution);
}
