package ci.gs2e.Gestion_Incidents.Service.Resolution;

import ci.gs2e.Gestion_Incidents.Modele.Resolution;
import ci.gs2e.Gestion_Incidents.Repository.ResolutionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class ResolutionServiceImpl implements ResolutionService{
    ResolutionRepository resolutionRepository;
    @Override
    public Resolution create(Resolution resolution) {

        return resolutionRepository.save(resolution);
    }

    @Override
    public Resolution edit(Resolution resolution) {
   Resolution existingReso = resolutionRepository.findById(resolution.getIdReso()).orElse(null);
   existingReso.setDescriptionReso(resolution.getDescriptionReso());

        return resolutionRepository.save(resolution);
    }

    @Override
    public void delete(int idReso) {
        resolutionRepository.deleteById(idReso);

    }

    @Override
    public List<Resolution> listAll() {

        return resolutionRepository.findAll();
    }

    @Override
    public Resolution listByLibelle(Resolution resolution) {

        return null;
    }
}
