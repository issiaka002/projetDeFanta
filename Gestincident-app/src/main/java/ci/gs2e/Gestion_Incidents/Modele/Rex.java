package ci.gs2e.Gestion_Incidents.Modele;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Setter
@Getter
@Table(name = "rex")
public class Rex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idRex;
    private String nom;
    private String prenom;
    private String fonction;

   // public Long getIdRex() {
       // return idRex;
    //}

   // public void setIdRex(Long idRex) {
     //   this.idRex = idRex;
   // }


    public int getIdRex() {
        return idRex;
    }

    public void setIdRex(int idRex) {
        this.idRex = idRex;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }
}
