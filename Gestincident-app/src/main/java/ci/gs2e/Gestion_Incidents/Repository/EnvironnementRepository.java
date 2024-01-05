package ci.gs2e.Gestion_Incidents.Repository;

import ci.gs2e.Gestion_Incidents.Modele.Environnement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnvironnementRepository extends JpaRepository<Environnement,Integer> {
    //Optional<Environnement> findByLibelleEnv(String libelleEnv);
    //Page<Environnement> findByLibelleContaining(String title, Pageable pageable);
    Optional<Environnement> findByLibelleEnvContains(String libelleEnv);
}
