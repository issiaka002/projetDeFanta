package ci.gs2e.Gestion_Incidents.Service.Application;

import ci.gs2e.Gestion_Incidents.Modele.Environnement;
import ci.gs2e.Gestion_Incidents.Modele.Logiciel;

import java.util.List;
import java.util.Optional;

public interface ApplicationService {
    public Logiciel create(Logiciel application);
    public  Logiciel edit(Logiciel application);
    public void delete(int idApp);
    public List<Logiciel> listAll();
    public Logiciel listByLibelle(Logiciel application);
    public Optional<Logiciel> listByLibelle(String libelleApp);
}
