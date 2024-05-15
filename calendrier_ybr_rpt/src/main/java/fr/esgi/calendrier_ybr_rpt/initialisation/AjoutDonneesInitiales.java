package fr.esgi.calendrier_ybr_rpt.initialisation;

import fr.esgi.calendrier_ybr_rpt.business.Jour;
import fr.esgi.calendrier_ybr_rpt.business.Theme;
import fr.esgi.calendrier_ybr_rpt.business.TypeReaction;
import fr.esgi.calendrier_ybr_rpt.business.Utilisateur;
import fr.esgi.calendrier_ybr_rpt.dto.in.UtilisateurCreationDTO;
import fr.esgi.calendrier_ybr_rpt.mapper.UtilisateurMapper;
import fr.esgi.calendrier_ybr_rpt.repository.JourRepository;
import fr.esgi.calendrier_ybr_rpt.repository.ThemeRepository;
import fr.esgi.calendrier_ybr_rpt.repository.TypeReactionRepository;
import fr.esgi.calendrier_ybr_rpt.repository.UtilisateurRepository;
import fr.esgi.calendrier_ybr_rpt.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@AllArgsConstructor
public class AjoutDonneesInitiales implements CommandLineRunner {
    private ThemeRepository themeRepository;
    private JourRepository jourRepository;
    private UtilisateurService utilisateurService;
    private UtilisateurMapper utilisateurMapper;

    private TypeReactionRepository typeReactionRepository;

    @Override
    public void run(String... args) throws Exception {
        ajouterTheme();
        ajouterJours();
        ajoutUtilisateur();
        ajoutTypesReaction();
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
        Random rdm = new Random();
        for (int i = 0; i < moisEnCours.lengthOfMonth(); i++) {
            int valeurJourAleatoire = rdm.nextInt(12) + 29;
            jourRepository.save(new Jour(premierJour.plusDays(i), valeurJourAleatoire));
        }
    }

    private void ajoutUtilisateur(){
        UtilisateurCreationDTO utilisateurCreationDTO = new UtilisateurCreationDTO();
        utilisateurCreationDTO.nom = "Peignet";
        utilisateurCreationDTO.prenom = "Robin";
        utilisateurCreationDTO.email = "robin@esgi.fr";
        utilisateurCreationDTO.motDePasse = "test";
        utilisateurCreationDTO.idTheme = 1L;
        utilisateurService.save(utilisateurMapper.toEntity(utilisateurCreationDTO));
    }

    private void ajoutTypesReaction(){
        List<TypeReaction> typesReaction = new ArrayList<>();
        typesReaction.add(new TypeReaction("1F600", "Visage souriant"));
        typesReaction.add(new TypeReaction("1F604", "Visage souriant avec des yeux souriants"));
        typesReaction.add(new TypeReaction("1F923", "Se rouler par terre en riant"));
        typesReaction.add(new TypeReaction("1F643", "Upside-down"));
        typesReaction.add(new TypeReaction("1F92A", "Visage loufoque"));
        typesReaction.add(new TypeReaction("1F4AF", "100 points"));
        typesReaction.add(new TypeReaction("1F937", "Homme qui hausse les épaules"));
        typeReactionRepository.saveAll(typesReaction);
    }
}
