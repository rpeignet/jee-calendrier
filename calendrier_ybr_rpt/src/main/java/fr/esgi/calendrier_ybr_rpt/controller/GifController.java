package fr.esgi.calendrier_ybr_rpt.controller;

import fr.esgi.calendrier_ybr_rpt.business.Gif;
import fr.esgi.calendrier_ybr_rpt.business.TypeReaction;
import fr.esgi.calendrier_ybr_rpt.dto.out.TypeReactionDTO;
import fr.esgi.calendrier_ybr_rpt.mapper.TypeReactionMapper;
import fr.esgi.calendrier_ybr_rpt.service.GifService;
import fr.esgi.calendrier_ybr_rpt.service.TypeReactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("gifs")
public class GifController {
    private TypeReactionService typeReactionService;
    private TypeReactionMapper typeReactionMapper;

    private GifService gifService;

    @GetMapping("/{id}/reagir")
    public ModelAndView reagir(@PathVariable Long id){
        ModelAndView mav = new ModelAndView("calendrier/template-reaction");

        Gif gif = gifService.findById(id);
        mav.addObject("prenomUtilisateur", gif.getUtilisateur().getPrenom());
        mav.addObject("gifFileName", gif.getFileName());

        List<TypeReactionDTO> typeReactions = typeReactionService.findAll().stream().map(typeReactionMapper::toDTO).toList();
        mav.addObject("typeReactions", typeReactions);
        return mav;
    }
}
