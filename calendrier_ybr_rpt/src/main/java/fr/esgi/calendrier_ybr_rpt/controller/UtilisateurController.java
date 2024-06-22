package fr.esgi.calendrier_ybr_rpt.controller;

import fr.esgi.calendrier_ybr_rpt.controller.rest.UtilisateurRestController;
import fr.esgi.calendrier_ybr_rpt.dto.in.UtilisateurCreationDTO;
import fr.esgi.calendrier_ybr_rpt.mapper.ThemeMapper;
import fr.esgi.calendrier_ybr_rpt.service.ThemeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class UtilisateurController {
    private ThemeService themeService;
    private ThemeMapper themeMapper;

    private UtilisateurRestController utilisateurRestController;

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

    @PostMapping("form-signin")
    public String formSignin(@ModelAttribute UtilisateurCreationDTO utilisateurCreationDTO){
        utilisateurRestController.create(utilisateurCreationDTO);
        return "redirect:/login";
    }
}
