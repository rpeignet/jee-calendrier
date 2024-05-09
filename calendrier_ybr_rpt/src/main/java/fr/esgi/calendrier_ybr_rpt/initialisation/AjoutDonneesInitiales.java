package fr.esgi.calendrier_ybr_rpt.initialisation;

import fr.esgi.calendrier_ybr_rpt.business.Jour;
import fr.esgi.calendrier_ybr_rpt.business.Theme;
import fr.esgi.calendrier_ybr_rpt.business.Utilisateur;
import fr.esgi.calendrier_ybr_rpt.dto.in.UtilisateurCreationDTO;
import fr.esgi.calendrier_ybr_rpt.repository.JourRepository;
import fr.esgi.calendrier_ybr_rpt.repository.ThemeRepository;
import fr.esgi.calendrier_ybr_rpt.repository.UtilisateurRepository;
import fr.esgi.calendrier_ybr_rpt.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class AjoutDonneesInitiales implements CommandLineRunner {
    private ThemeRepository themeRepository;
    private JourRepository jourRepository;
    private UtilisateurService utilisateurService;

    @Override
    public void run(String... args) throws Exception {
        ajouterTheme();
        ajouterJours();
        ajoutUtilisateur();
    }

    private void ajouterTheme(){
        Theme light = new Theme("light");
        Theme dark = new Theme("dark");
        themeRepository.save(light);
        themeRepository.save(dark);
    }

    private void ajouterJours(){
        YearMonth moisEnCours = YearMonth.now();
        LocalDate premierJour = moisEnCours.atDay(1);
        for (int i = 0; i < moisEnCours.lengthOfMonth(); i++) {
            jourRepository.save(new Jour(premierJour.plusDays(i)));
        }
    }

    private void ajoutUtilisateur(){
        UtilisateurCreationDTO utilisateurCreationDTO = new UtilisateurCreationDTO();
        utilisateurCreationDTO.nom = "Peignet";
        utilisateurCreationDTO.prenom = "Robin";
        utilisateurCreationDTO.email = "robin@esgi.fr";
        utilisateurCreationDTO.motDePasse = "test";
        utilisateurCreationDTO.idTheme = 1L;
        utilisateurService.save(utilisateurCreationDTO);
    }
}
