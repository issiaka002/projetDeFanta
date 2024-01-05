package ci.gs2e.Gestion_Incidents.Modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "environnement")
public class Environnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEnv;
    //private String codeEnv;
    private String libelleEnv;


    public int getIdEnv() {
        return idEnv;
    }

    public void setIdEnv(int idEnv) {
        this.idEnv = idEnv;
    }


    public String getLibelleEnv() {
        return libelleEnv;
    }

    public void setLibelleEnv(String libelleEnv) {
        this.libelleEnv = libelleEnv;
    }
}
