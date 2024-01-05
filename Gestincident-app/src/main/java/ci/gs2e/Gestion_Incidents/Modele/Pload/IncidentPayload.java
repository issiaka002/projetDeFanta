package ci.gs2e.Gestion_Incidents.Modele.Pload;

import ci.gs2e.Gestion_Incidents.Modele.AppEnvironnement;
import ci.gs2e.Gestion_Incidents.Modele.Environnement;
import ci.gs2e.Gestion_Incidents.Modele.Incident;
import ci.gs2e.Gestion_Incidents.Modele.Logiciel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IncidentPayload {
    private int idInc;
    //private String codeInc;
    private String libelleInc;
    //private AppEnvironnement appEnvironnement;
    private int logiciel;
    private int environnement;
    private MultipartFile document;
    private String resolution;



}
