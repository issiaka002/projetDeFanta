package ci.gs2e.Gestion_Incidents.Service.Rex;

import ci.gs2e.Gestion_Incidents.Modele.Rex;
import ci.gs2e.Gestion_Incidents.Modele.RexPage;
import ci.gs2e.Gestion_Incidents.Modele.RexSearchCriteria;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface RexService {
    public Rex create(Rex rex);
    public  Rex edit(Rex rex);
    public void delete(int idRex);
    public List<Rex> listAll();
    public Rex listByLibelle(Rex rex);

    public Optional<Rex> findById(int idRex);
    public Page<Rex> getRex(RexPage rexPage, RexSearchCriteria rexSearchCriteria);
    public Rex FindByNom(String nom);
    List<Rex> searchRex(String keyword);
}
