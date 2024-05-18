package fr.esgi.calendrier_ybr_rpt.service.impl;

import fr.esgi.calendrier_ybr_rpt.business.Utilisateur;
import fr.esgi.calendrier_ybr_rpt.exception.MissingParamException;
import fr.esgi.calendrier_ybr_rpt.exception.utilisateur.UtilisateurNotFoundException;
import fr.esgi.calendrier_ybr_rpt.repository.UtilisateurRepository;
import fr.esgi.calendrier_ybr_rpt.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {
    private UtilisateurRepository utilisateurRepository;

    @Override
    public Utilisateur save(Utilisateur utilisateur){
        utilisateur.setNombreDePoint(500);
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Utilisateur findById(Long id) {
        if(id != null){
            Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
            if(utilisateur.isPresent()){
                return utilisateur.get();
            }else{
                throw new UtilisateurNotFoundException();
            }
        }else{
            throw new MissingParamException();
        }
    }
}
