package fr.esgi.calendrier_ybr_rpt.service;

import fr.esgi.calendrier_ybr_rpt.business.Utilisateur;
import fr.esgi.calendrier_ybr_rpt.dto.in.UtilisateurCreationDTO;

public interface UtilisateurService {
    public Utilisateur save(Utilisateur utilisateur);
    public Utilisateur findById(Long id);
}
