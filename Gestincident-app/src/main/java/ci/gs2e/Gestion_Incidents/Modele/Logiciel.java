package ci.gs2e.Gestion_Incidents.Modele;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Data
@Builder
@Table(name = "logiciel")
public class Logiciel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idApp;
    //private String codeApp;
    private String libelleApp;
    private String descriptionApp;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idRex")
   private Rex rex;

    public void setIdApp(int idApp) {
        this.idApp = idApp;
    }

    public Rex getRex() {
        return rex;
    }

    public void setRex(Rex rex) {
        this.rex = rex;
    }


    public int getIdApp() {
        return idApp;
    }





    public String getLibelleApp() {
        return libelleApp;
    }

    public void setLibelleApp(String libelleApp) {
        this.libelleApp = libelleApp;
    }

    public String getDescriptionApp() {
        return descriptionApp;
    }

    public void setDescriptionApp(String descriptionApp) {
        this.descriptionApp = descriptionApp;
    }
}
