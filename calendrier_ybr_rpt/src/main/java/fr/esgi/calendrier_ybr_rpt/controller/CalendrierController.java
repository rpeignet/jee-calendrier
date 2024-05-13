package fr.esgi.calendrier_ybr_rpt.controller;

import fr.esgi.calendrier_ybr_rpt.business.Jour;
import fr.esgi.calendrier_ybr_rpt.business.Utilisateur;
import fr.esgi.calendrier_ybr_rpt.dto.out.GifPlacementDTO;
import fr.esgi.calendrier_ybr_rpt.mapper.UtilisateurMapper;
import fr.esgi.calendrier_ybr_rpt.service.JourService;
import fr.esgi.calendrier_ybr_rpt.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping("calendrier")
public class CalendrierController {
    private UtilisateurService utilisateurService;
    private UtilisateurMapper utilisateurMapper;
    private JourService jourService;

    // TODO : voir si on continue de passer l'id utilisateur en param, après avoir correctement gérer le connexion/deconnexion avec spring security
    @GetMapping("/{idUtilisateur}")
    public ModelAndView findAll(@PathVariable Long idUtilisateur, @PageableDefault(size = 7) Pageable pageable){
        ModelAndView mav = new ModelAndView("calendrier/template");

        Utilisateur utilisateur = utilisateurService.findById(idUtilisateur);
        mav.addObject("theme", "/main-" + utilisateur.getTheme().getLibelle() + ".css");
        mav.addObject("utilisateurDTO", utilisateurMapper.toDTO(utilisateur));

        Page<Jour> pageDeJours = jourService.findAll(pageable);
        mav.addObject("pageDeJours", pageDeJours);

        String joursEnCours = "Jours " + pageDeJours.toList().get(0).getDate().getDayOfMonth() + " à " + pageDeJours.toList().get(pageDeJours.getContent().size() - 1).getDate().getDayOfMonth() + " sur " + pageDeJours.toList().get(0).getDate().getMonth().length(true);
        mav.addObject("joursEnCours", joursEnCours);

        return mav;
    }

    @GetMapping("/{idUtilisateur}/{id}/placer")
    public ModelAndView create(@PathVariable Long idUtilisateur, @PathVariable Long id){
        ModelAndView mav = new ModelAndView("calendrier/template-placement");
        Utilisateur utilisateur = utilisateurService.findById(idUtilisateur);
        Jour jour = jourService.findById(id);
        GifPlacementDTO gifPlacementDTO = new GifPlacementDTO(utilisateur.getId(), jour.getId(), jour.getDate(), jour.getValeur());
        mav.addObject("gifPlacementDTO", gifPlacementDTO);
        return mav;
    }
}
