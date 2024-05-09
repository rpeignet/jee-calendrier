package fr.esgi.calendrier_ybr_rpt.controller;

import fr.esgi.calendrier_ybr_rpt.business.Jour;
import fr.esgi.calendrier_ybr_rpt.business.Utilisateur;
import fr.esgi.calendrier_ybr_rpt.mapper.ThemeMapper;
import fr.esgi.calendrier_ybr_rpt.mapper.UtilisateurMapper;
import fr.esgi.calendrier_ybr_rpt.service.JourService;
import fr.esgi.calendrier_ybr_rpt.service.ThemeService;
import fr.esgi.calendrier_ybr_rpt.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class UtilisateurController {
    private ThemeService themeService;
    private ThemeMapper themeMapper;

    @GetMapping({"login", "/"})
    public ModelAndView login(){
        return new ModelAndView("utilisateur/login");
    }

    @GetMapping("signin")
    public ModelAndView signin(){
        ModelAndView mav = new ModelAndView("utilisateur/signin");
        mav.addObject("themes", themeService.findAllForSelection().stream().map(themeMapper::toDTO).toList());
        return mav;
    }
}
