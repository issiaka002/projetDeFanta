package ci.gs2e.Gestion_Incidents.Service.AppEnv;

import ci.gs2e.Gestion_Incidents.Modele.AppEnvironnement;
import ci.gs2e.Gestion_Incidents.Modele.Environnement;
import ci.gs2e.Gestion_Incidents.Repository.AppEnvRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class AppEnvServiceImpl implements AppEnvService{
    @Autowired
    AppEnvRepository appEnvRepository;
    @Override
    public AppEnvironnement create(AppEnvironnement appEnvironnement) {
        return appEnvRepository.save(appEnvironnement);
    }

    @Override
    public AppEnvironnement edit(AppEnvironnement appEnvironnement) {
        AppEnvironnement existingAppEnv = appEnvRepository.findById(appEnvironnement.getIdAppEnv()).orElse(null);
        existingAppEnv.setLogiciel(appEnvironnement.getLogiciel());
        existingAppEnv.setEnvironnement(appEnvironnement.getEnvironnement());



        return appEnvRepository.save(existingAppEnv);
    }

    @Override
    public void delete(int idAppEnv) {
        appEnvRepository.deleteById(idAppEnv);

    }

    @Override
    public List<AppEnvironnement> listAll() {
        return appEnvRepository.findAll();
    }

    @Override
    public Optional<Environnement> listByLibelle(Environnement env) {
        return appEnvRepository.findByEnvironnement(env);
    }
}
