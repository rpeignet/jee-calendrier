package fr.esgi.calendrier_ybr_rpt.service.impl;

import org.springframework.stereotype.Service;

@Service
public class UserConnectedService {
    private Long idUtilisateurConnecte;

    public Long getIdUtilisateurConnecte(){
        return idUtilisateurConnecte;
    }

    public void setIdUtilisateurConnecte(Long id){
        idUtilisateurConnecte = id;
    }
}
