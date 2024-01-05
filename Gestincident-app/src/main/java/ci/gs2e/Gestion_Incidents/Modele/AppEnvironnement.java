package ci.gs2e.Gestion_Incidents.Modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import ci.gs2e.Gestion_Incidents.Modele.Logiciel;
import ci.gs2e.Gestion_Incidents.Modele.Environnement;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "appEnvironnement")
public class AppEnvironnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAppEnv;
    //private String codeAppEnv;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idApp")
    private Logiciel logiciel;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idEnv")
    private Environnement environnement;

    public Logiciel getLogiciel() {
        return logiciel;
    }

    public void setLogiciel(Logiciel logiciel) {
        this.logiciel = logiciel;
    }

    public Environnement getEnvironnement() {
        return environnement;
    }

    public void setEnvironnement(Environnement environnement) {
        this.environnement = environnement;
    }

    public int getIdAppEnv() {
        return idAppEnv;
    }

    public void setIdAppEnv(int idAppEnv) {
        this.idAppEnv = idAppEnv;
    }
}
