package fr.esgi.calendrier_ybr_rpt.business;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Gif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String urlFichier;

    private String Legende;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jour_id")
    private Jour jour;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
