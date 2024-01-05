package ci.gs2e.Gestion_Incidents.Service.Rex;

import ci.gs2e.Gestion_Incidents.Modele.Incident;
import ci.gs2e.Gestion_Incidents.Modele.Rex;
import ci.gs2e.Gestion_Incidents.Modele.RexPage;
import ci.gs2e.Gestion_Incidents.Modele.RexSearchCriteria;
import ci.gs2e.Gestion_Incidents.Repository.RexCriteriaRepository;
import ci.gs2e.Gestion_Incidents.Repository.RexRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class RexServiceImpl implements RexService{
    @Autowired
    private RexRepository rexRepository;
    @Autowired
    private RexCriteriaRepository rexCriteriaRepository;


    public Rex create(Rex rex){

        return rexRepository.save(rex);
    }
    public Rex edit(Rex rex){

        Rex existingRex = rexRepository.findById(rex.getIdRex()).orElse(null);
        existingRex.setNom(rex.getNom());
        existingRex.setPrenom(rex.getPrenom());
        existingRex.setFonction(rex.getFonction());

        return rexRepository.save(existingRex);

       // return null;
    }

    public  void delete(int idRex){

        rexRepository.deleteById(idRex);
    }

    public List<Rex> listAll(){
        return rexRepository.findAll();
    }
    @Override
    public Page<Rex> getRex(RexPage rexPage, RexSearchCriteria rexSearchCriteria){
        return rexCriteriaRepository.findAllFilters(rexPage, rexSearchCriteria);

    }

    @Override
    public Rex FindByNom(String nom) {


        return null;
    }

    @Override
    public List<Rex> searchRex(String keyword) {
        List<Rex> customers=rexRepository.searchRex(keyword);
        return customers;
    }

    @Override
    public Rex listByLibelle(Rex rex) {

        return null;
    }

    @Override
    public Optional<Rex> findById(int idRex) {

        return rexRepository.findById(idRex);
    }

}

