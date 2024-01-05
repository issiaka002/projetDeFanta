package ci.gs2e.Gestion_Incidents.Repository;

import ci.gs2e.Gestion_Incidents.Modele.AppEnvironnement;
import ci.gs2e.Gestion_Incidents.Modele.Environnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppEnvRepository extends JpaRepository<AppEnvironnement,Integer> {
    Optional<Environnement> findByEnvironnement(Environnement env);
}
