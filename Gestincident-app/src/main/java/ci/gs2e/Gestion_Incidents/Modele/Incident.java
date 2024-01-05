package ci.gs2e.Gestion_Incidents.Modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.Text;

import java.io.File;
import java.sql.Blob;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "incident")
public class Incident {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInc;
    //private String codeInc;
    private String libelleInc;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idAppEnv")
    private AppEnvironnement appEnvironnement;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idApp")
    private Logiciel logiciel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idEnv")
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

   // public String getResolution() {
   //     return resolution;
   // }
    // @ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "idReso")
    //private  Resolution resolution;

    private String resolution;


    //public void setResolution(String resolution) {
      //  this.resolution = resolution;
   // }

    public AppEnvironnement getAppEnvironnement() {
        return appEnvironnement;
    }

    public void setAppEnvironnement(AppEnvironnement appEnvironnement) {
        this.appEnvironnement = appEnvironnement;
    }

    //public Resolution getResolution() {
       // return resolution;
    //}

    //public void setResolution(Resolution resolution) {
      //  this.resolution = resolution;
    //}


    public int getIdInc() {
        return idInc;
    }

    public void setIdInc(int idInc) {
        this.idInc = idInc;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getLibelleInc() {
        return libelleInc;
    }

    public void setLibelleInc(String libelleInc) {
        this.libelleInc = libelleInc;
    }
}
