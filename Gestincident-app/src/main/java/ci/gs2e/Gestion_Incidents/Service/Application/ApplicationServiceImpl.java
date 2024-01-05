package ci.gs2e.Gestion_Incidents.Service.Application;

import ci.gs2e.Gestion_Incidents.Modele.Logiciel;
import ci.gs2e.Gestion_Incidents.Repository.AppEnvRepository;
import ci.gs2e.Gestion_Incidents.Repository.ApplicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class ApplicationServiceImpl implements ApplicationService{
    @Autowired
   private ApplicationRepository applicationRepository;
    @Override
    public Logiciel create(Logiciel application) {

        return applicationRepository.save(application);
    }

    @Override
    public Logiciel edit(Logiciel application) {
     Logiciel existingApp = applicationRepository.findById(application.getIdApp()).orElse(null);
       existingApp.setLibelleApp(application.getLibelleApp());
       existingApp.setDescriptionApp(application.getDescriptionApp());
       existingApp.setRex(application.getRex());
        return applicationRepository.save(existingApp);
    }

    @Override
    public void delete(int idApp) {
        applicationRepository.deleteById(idApp);

    }

    @Override
    public List<Logiciel> listAll() {

        return applicationRepository.findAll();
    }

    @Override
    public Logiciel listByLibelle(Logiciel application) {
        return null;
    }

    @Override
    public Optional<Logiciel> listByLibelle(String libelleApp) {
        return applicationRepository.findByLibelleAppContains(libelleApp);
    }


}
