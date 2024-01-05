package ci.gs2e.Gestion_Incidents.Repository;

import ci.gs2e.Gestion_Incidents.Modele.Rex;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RexRepository extends JpaRepository<Rex,Integer> {
    @Query(value = "SELECT t.* FROM rex t ", nativeQuery = true)
    Page<Rex> findPage(Pageable pageable);

    @Query("select c from Rex c where c.nom like :kw")
    List<Rex> searchRex(@Param("kw") String keyword);


 }
