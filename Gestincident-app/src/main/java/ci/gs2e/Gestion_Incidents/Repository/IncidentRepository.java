package ci.gs2e.Gestion_Incidents.Repository;

import ci.gs2e.Gestion_Incidents.Modele.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentRepository extends JpaRepository<Incident,Integer> {
}
