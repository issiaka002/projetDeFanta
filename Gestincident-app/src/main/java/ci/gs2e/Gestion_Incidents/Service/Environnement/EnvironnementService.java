package ci.gs2e.Gestion_Incidents.Service.Environnement;

import ci.gs2e.Gestion_Incidents.Modele.Environnement;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface EnvironnementService {
    public Environnement create(Environnement environnement);
    public  Environnement edit(Environnement environnement);
    public void delete(int idEnv);
    public List<Environnement> listAll();
    Page<Environnement> getEnvironnementPagination(Integer pageNumber, Integer pageSize, String sort);
    public Optional<Environnement> listByLibelle(String libelleEnv);
    //Environnement getAccountHistory(int idEnv,int page, int size) throws Exception;




}
