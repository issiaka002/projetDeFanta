package ci.gs2e.Gestion_Incidents.Service.AppEnv;

import ci.gs2e.Gestion_Incidents.Modele.AppEnvironnement;
import ci.gs2e.Gestion_Incidents.Modele.Environnement;

import java.util.List;
import java.util.Optional;

public interface AppEnvService {
    public AppEnvironnement create(AppEnvironnement appEnvironnement);
    public AppEnvironnement edit(AppEnvironnement appEnvironnement);
    public void delete(int idAppEnv);
    public List<AppEnvironnement> listAll();
    public Optional<Environnement> listByLibelle(Environnement env);
}
