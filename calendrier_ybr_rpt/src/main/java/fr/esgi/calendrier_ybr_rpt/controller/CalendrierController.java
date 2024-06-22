package fr.esgi.calendrier_ybr_rpt.controller;

import fr.esgi.calendrier_ybr_rpt.business.Jour;
import fr.esgi.calendrier_ybr_rpt.business.Utilisateur;
import fr.esgi.calendrier_ybr_rpt.controller.rest.GifRestController;
import fr.esgi.calendrier_ybr_rpt.dto.in.GifCreationDTO;
import fr.esgi.calendrier_ybr_rpt.dto.out.GifPlacementDTO;
import fr.esgi.calendrier_ybr_rpt.mapper.UtilisateurMapper;
import fr.esgi.calendrier_ybr_rpt.service.JourService;
import fr.esgi.calendrier_ybr_rpt.service.UtilisateurService;
import fr.esgi.calendrier_ybr_rpt.service.impl.UserConnectedService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping("calendrier")
public class CalendrierController {
    private UtilisateurService utilisateurService;
    private UtilisateurMapper utilisateurMapper;
    private JourService jourService;
    private GifRestController gifRestController;
    private UserConnectedService userConnectedService;

    @GetMapping("")
    public ModelAndView findAll(@PageableDefault(size = 7, direction = Sort.Direction.ASC) Pageable pageable){
        ModelAndView mav = new ModelAndView("calendrier/template");

        Utilisateur utilisateur = utilisateurService.findById(userConnectedService.getIdUtilisateurConnecte());
        mav.addObject("theme", "/main-" + utilisateur.getTheme().getLibelle() + ".css");
        mav.addObject("utilisateurDTO", utilisateurMapper.toDTO(utilisateur));

        Page<Jour> pageDeJours = jourService.findAll(pageable);
        mav.addObject("pageDeJours", pageDeJours);

        String joursEnCours = "Jours " + pageDeJours.toList().get(0).getDate().getDayOfMonth() + " à " + pageDeJours.toList().get(pageDeJours.getContent().size() - 1).getDate().getDayOfMonth() + " sur " + pageDeJours.toList().get(0).getDate().getMonth().length(true);
        mav.addObject("joursEnCours", joursEnCours);

        return mav;
    }

    @GetMapping("/{id}/placer-gif")
    public ModelAndView placer(@PathVariable Long id){
        ModelAndView mav = new ModelAndView("calendrier/template-placement");
        Utilisateur utilisateur = utilisateurService.findById(userConnectedService.getIdUtilisateurConnecte());
        Jour jour = jourService.findById(id);
        GifPlacementDTO gifPlacementDTO = new GifPlacementDTO(utilisateur.getId(), jour.getId(), jour.getDate(), jour.getValeur());
        mav.addObject("gifPlacementDTO", gifPlacementDTO);
        mav.addObject("theme", "/main-" + utilisateur.getTheme().getLibelle() + ".css");
        return mav;
    }

    @GetMapping("/{id}/televerser-gif")
    public ModelAndView televerser(@PathVariable Long id){
        ModelAndView mav = new ModelAndView("calendrier/template-televersement");
        Utilisateur utilisateur = utilisateurService.findById(userConnectedService.getIdUtilisateurConnecte());
        Jour jour = jourService.findById(id);
        GifPlacementDTO gifPlacementDTO = new GifPlacementDTO(utilisateur.getId(), jour.getId(), jour.getDate(), jour.getValeur());
        mav.addObject("gifPlacementDTO", gifPlacementDTO);
        mav.addObject("theme", "/main-" + utilisateur.getTheme().getLibelle() + ".css");
        return mav;
    }

    @PostMapping("/form-placement-gif")
    public String formPlacementGif(@ModelAttribute GifCreationDTO gifCreationDTO) {
        gifRestController.placer(gifCreationDTO);
        return "redirect:/calendrier";
    }

    @PostMapping("/form-televersement-gif")
    public String formTeleversementGif(@ModelAttribute GifCreationDTO gifCreationDTO, @RequestParam("file") MultipartFile file) {
        gifRestController.televerser(gifCreationDTO, file);
        return "redirect:/calendrier";
    }
}
