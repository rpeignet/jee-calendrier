package fr.esgi.calendrier_ybr_rpt.service.impl;

import fr.esgi.calendrier_ybr_rpt.business.Theme;
import fr.esgi.calendrier_ybr_rpt.business.Utilisateur;
import fr.esgi.calendrier_ybr_rpt.dto.in.UtilisateurCreationDTO;
import fr.esgi.calendrier_ybr_rpt.mapper.UtilisateurMapper;
import fr.esgi.calendrier_ybr_rpt.repository.UtilisateurRepository;
import fr.esgi.calendrier_ybr_rpt.service.ThemeService;
import fr.esgi.calendrier_ybr_rpt.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {
    private UtilisateurRepository utilisateurRepository;
    private ThemeService themeService;
    private UtilisateurMapper utilisateurMapper;

    @Override
    public Utilisateur save(UtilisateurCreationDTO utilisateurCreationdto){
        Utilisateur utilisateur = utilisateurMapper.toEntity(utilisateurCreationdto);
        Theme theme = themeService.findById(utilisateurCreationdto.idTheme);
        utilisateur.setTheme(theme);
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
                throw new RuntimeException("404 : utilisateur non trouvé");
            }
        }else{
            throw new RuntimeException("Vous devez renseigner un identitifiant utilisateur");
        }
    }
}
