package fr.esgi.calendrier_ybr_rpt.handler;

import fr.esgi.calendrier_ybr_rpt.service.UtilisateurService;
import fr.esgi.calendrier_ybr_rpt.service.impl.UserConnectedService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private final UserConnectedService userConnectedService;
    private final UtilisateurService utilisateurService;
    public LoginSuccessHandler(UserConnectedService userConnectedService, UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
        this.userConnectedService = userConnectedService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Long idUtilisateurConnecte = utilisateurService.findByEmail(userDetails.getUsername()).getId();
        userConnectedService.setIdUtilisateurConnecte(idUtilisateurConnecte);
        response.sendRedirect("/calendrier");
    }
}
