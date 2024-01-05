package ci.gs2e.Gestion_Incidents.Repository;

import ci.gs2e.Gestion_Incidents.Modele.Environnement;
import ci.gs2e.Gestion_Incidents.Modele.Logiciel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Logiciel,Integer> {
    Optional<Logiciel> findByLibelleAppContains(String libelleApp);

}
