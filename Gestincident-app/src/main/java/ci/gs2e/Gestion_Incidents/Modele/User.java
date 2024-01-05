package ci.gs2e.Gestion_Incidents.Modele;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    private String nom;
    private String prenom;
    //private String username;
    //@Column(unique = true)
    private String email;
    private  String password;
    //private String roles;


    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

   /* public void setRoles(String roles) {
        this.roles = roles;
    }

    */

    public int getIdUser() {
        return idUser;
    }
/*
    public String getRoles() {
        return roles;
    }

 */

    public User(String email, String password) {
        this.email = email;
        this.password = password;
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
/*
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

 */

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
