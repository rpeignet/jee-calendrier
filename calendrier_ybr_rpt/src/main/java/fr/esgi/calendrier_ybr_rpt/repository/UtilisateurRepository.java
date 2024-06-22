package fr.esgi.calendrier_ybr_rpt.repository;

import fr.esgi.calendrier_ybr_rpt.business.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    public Utilisateur findByEmail(String email);
}
