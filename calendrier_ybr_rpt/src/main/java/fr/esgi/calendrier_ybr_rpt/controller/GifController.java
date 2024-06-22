package fr.esgi.calendrier_ybr_rpt.controller;

import fr.esgi.calendrier_ybr_rpt.business.Gif;
import fr.esgi.calendrier_ybr_rpt.business.Utilisateur;
import fr.esgi.calendrier_ybr_rpt.controller.rest.ReactionRestController;
import fr.esgi.calendrier_ybr_rpt.dto.in.ReactionCreationDTO;
import fr.esgi.calendrier_ybr_rpt.dto.out.TypeReactionDTO;
import fr.esgi.calendrier_ybr_rpt.mapper.TypeReactionMapper;
import fr.esgi.calendrier_ybr_rpt.service.GifService;
import fr.esgi.calendrier_ybr_rpt.service.TypeReactionService;
import fr.esgi.calendrier_ybr_rpt.service.UtilisateurService;
import fr.esgi.calendrier_ybr_rpt.service.impl.UserConnectedService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("gifs")
public class GifController {
    private TypeReactionService typeReactionService;
    private TypeReactionMapper typeReactionMapper;
    private GifService gifService;
    private UserConnectedService userConnectedService;
    private UtilisateurService utilisateurService;
    private ReactionRestController reactionRestController;

    @GetMapping("/{id}/reagir")
    public ModelAndView reagir(@PathVariable Long id){
        ModelAndView mav = new ModelAndView("calendrier/template-reaction");
        mav.addObject("idGif", id);

        Utilisateur utilisateurConnecte = utilisateurService.findById(userConnectedService.getIdUtilisateurConnecte());
        mav.addObject("theme", "/main-" + utilisateurConnecte.getTheme().getLibelle() + ".css");

        Gif gif = gifService.findById(id);
        mav.addObject("prenomUtilisateur", gif.getUtilisateur().getPrenom());
        mav.addObject("gifFileName", gif.getFileName());

        List<TypeReactionDTO> typeReactions = typeReactionService.findAll().stream().map(typeReactionMapper::toDTO).toList();
        mav.addObject("typeReactions", typeReactions);
        return mav;
    }

    @PostMapping("/form-react-gif")
    public String formReactGif(@ModelAttribute ReactionCreationDTO reactionCreationDTO){
        reactionRestController.create(reactionCreationDTO);
        return "redirect:/calendrier";
    }
}
