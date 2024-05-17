package fr.esgi.calendrier_ybr_rpt.business;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Gif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = ".*\\.(?i)(gif)$", message = "Le Gif distant doit pointer vers une URL au bon format qui se termine par .gif, .Gif ou .GIF")
    private String urlFichier;

    private String fileName;

    private String Legende;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jour_id")
    private Jour jour;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    @JsonManagedReference
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "gif", cascade = CascadeType.ALL)
    private List<Reaction> reactions;

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Jour getJour() {
        return jour;
    }

    public void setJour(Jour jour) {
        this.jour = jour;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrlFichier() {
        return urlFichier;
    }

    public void setUrlFichier(String urlFichier) {
        this.urlFichier = urlFichier;
    }
}
