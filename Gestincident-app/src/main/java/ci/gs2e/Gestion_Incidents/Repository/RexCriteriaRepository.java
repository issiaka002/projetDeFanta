package ci.gs2e.Gestion_Incidents.Repository;

import ci.gs2e.Gestion_Incidents.Modele.Rex;
import ci.gs2e.Gestion_Incidents.Modele.RexPage;
import ci.gs2e.Gestion_Incidents.Modele.RexSearchCriteria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.springframework.data.jpa.convert.QueryByExamplePredicateBuilder.getPredicate;

@Repository
public class RexCriteriaRepository {
    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public RexCriteriaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    public Page<Rex> findAllFilters(RexPage rexPage, RexSearchCriteria rexSearchCriteria) {
        CriteriaQuery<Rex> criteriaQuery = criteriaBuilder.createQuery(Rex.class);
        Root<Rex> rexRoot = criteriaQuery.from(Rex.class);
        Predicate predicate = getPredicate(rexSearchCriteria, rexRoot);
        criteriaQuery.where(predicate);
        setOrder(rexPage, criteriaQuery, rexRoot);
        TypedQuery<Rex> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(rexPage.getPageNumber() * rexPage.getPageSize());
        typedQuery.setMaxResults(rexPage.getPageSize());
        Pageable pageable =getPageable(rexPage);
        long rexCount =     getRexCount(predicate);
        return  new PageImpl<>(typedQuery.getResultList(),pageable, rexCount);
    }




    private Predicate getPredicate(RexSearchCriteria rexSearchCriteria, Root<Rex> rexRoot) {
        List<Predicate> predicates = new ArrayList<>();
        if (Objects.nonNull(rexSearchCriteria.getNom())) {
            predicates.add(criteriaBuilder.like(rexRoot.get("nom"), "%" + rexSearchCriteria.getNom()
                    + "%"));
        }
        if (Objects.nonNull(rexSearchCriteria.getPrenom())) {
            predicates.add(criteriaBuilder.like(rexRoot.get("prenom"), "%" + rexSearchCriteria.getPrenom()
                    + "%"));

        }
        return criteriaBuilder.and(predicates.toArray(predicates.toArray(new Predicate[0])));
    }

    private void setOrder(RexPage rexPage, CriteriaQuery<Rex> criteriaQuery, Root<Rex> rexRoot) {
    if(rexPage.getSortDirection().equals(Sort.Direction.DESC)){
        criteriaQuery.orderBy(criteriaBuilder.desc(rexRoot.get(rexPage.getSortBy())));
    }
    else {
        criteriaQuery.orderBy(criteriaBuilder.asc(rexRoot.get(rexPage.getSortBy())));
    }

    }
    private Pageable getPageable(RexPage rexPage) {
        Sort sort = Sort.by(rexPage.getSortDirection(), rexPage.getSortBy());
        return PageRequest.of(rexPage.getPageNumber(), rexPage.getPageSize(), sort);
    }
    private long getRexCount(Predicate predicate) {
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<Rex> countRoot = countQuery.from(Rex.class);
        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
        return entityManager.createQuery(countQuery).getSingleResult();

    }
}
