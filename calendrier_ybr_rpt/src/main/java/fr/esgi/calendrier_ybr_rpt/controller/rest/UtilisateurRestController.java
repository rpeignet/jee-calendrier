package fr.esgi.calendrier_ybr_rpt.controller.rest;

import fr.esgi.calendrier_ybr_rpt.business.Utilisateur;
import fr.esgi.calendrier_ybr_rpt.dto.in.UtilisateurCreationDTO;
import fr.esgi.calendrier_ybr_rpt.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/utilisateurs")
@AllArgsConstructor
public class UtilisateurRestController {
    private UtilisateurService utilisateurService;

    @PostMapping("")
    @ResponseStatus(code= HttpStatus.CREATED)
    public Utilisateur create(@RequestBody UtilisateurCreationDTO utilisateurCreationDTO){
        return utilisateurService.save(utilisateurCreationDTO);
    }
}
