package fr.esgi.calendrier_ybr_rpt.business;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "L’utilisateur doit préciser son nom, prénom, son mail et un mot de passe")
    @NotEmpty(message = "L’utilisateur doit préciser son nom, prénom, son mail et un mot de passe")
    private String nom;
    @NotEmpty(message = "L’utilisateur doit préciser son nom, prénom, son mail et un mot de passe")
    @NotNull(message = "L’utilisateur doit préciser son nom, prénom, son mail et un mot de passe")
    private String prenom;
    @NotEmpty
    @Email(message = "L'email doit être au bon format")
    @Pattern(regexp=".+@esgi\\.fr", message="L’email de l’utilisateur doit avoir un format valide appartenant au nom de domaine esgi.fr")
    private String email;

    @Size(min = 3, message = "Le mot de passe de l’utilisateur doit contenir au moins 3 caractères.")
    private String motDePasse;
    private int nombreDePoint;

    @ManyToOne
    @JoinColumn(name = "theme_id")
    @NotNull(message = "L’utilisateur doit obligatoirement choisir un thème")
    @JsonManagedReference
    private Theme theme;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<Gif> gifs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public int getNombreDePoint() {
        return nombreDePoint;
    }

    public void setNombreDePoint(int nombreDePoint) {
        this.nombreDePoint = nombreDePoint;
    }

    public String getPrenom() {
        return prenom;
    }
}
