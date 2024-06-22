package fr.esgi.calendrier_ybr_rpt.service;

import fr.esgi.calendrier_ybr_rpt.business.Utilisateur;

public interface UtilisateurService {
    public Utilisateur save(Utilisateur utilisateur);
    public Utilisateur findById(Long id);
    public Utilisateur findByEmail(String email);
}
