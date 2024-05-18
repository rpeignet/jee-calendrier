package fr.esgi.calendrier_ybr_rpt.controller.rest;

import fr.esgi.calendrier_ybr_rpt.business.Reaction;
import fr.esgi.calendrier_ybr_rpt.dto.in.ReactionCreationDTO;
import fr.esgi.calendrier_ybr_rpt.mapper.ReactionMapper;
import fr.esgi.calendrier_ybr_rpt.service.ReactionService;
import fr.esgi.calendrier_ybr_rpt.service.impl.UserConnectedService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reactions")
@AllArgsConstructor
public class ReactionRestController {

    private ReactionService reactionService;
    private ReactionMapper reactionMapper;

    private UserConnectedService userConnectedService;

    @PostMapping("")
    @ResponseStatus(code= HttpStatus.CREATED)
    public Reaction create(@RequestBody ReactionCreationDTO reactionCreationDTO){
        if (reactionCreationDTO.idUtilisateur == null) {
            reactionCreationDTO.idUtilisateur = userConnectedService.getIdUtilisateurConnecte();
        }
        return reactionService.save(reactionMapper.toEntity(reactionCreationDTO));
    }
}
