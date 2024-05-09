package fr.esgi.calendrier_ybr_rpt.business;

import jakarta.persistence.*;

@Entity
public class Gif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String urlFichier;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jour_id")
    private Jour jour;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;
}
