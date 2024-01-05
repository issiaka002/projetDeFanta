package ci.gs2e.Gestion_Incidents.Modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "resolution")
public class Resolution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReso;
   // private String codeReso;
    private String descriptionReso;

    public int getIdReso() {
        return idReso;
    }

    public void setIdReso(int idReso) {
        this.idReso = idReso;
    }



    public String getDescriptionReso() {
        return descriptionReso;
    }

    public void setDescriptionReso(String descriptionReso) {
        this.descriptionReso = descriptionReso;
    }
}
