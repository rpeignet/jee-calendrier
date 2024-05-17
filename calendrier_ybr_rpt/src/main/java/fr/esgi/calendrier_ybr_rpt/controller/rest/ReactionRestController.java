package fr.esgi.calendrier_ybr_rpt.controller.rest;

import fr.esgi.calendrier_ybr_rpt.business.Reaction;
import fr.esgi.calendrier_ybr_rpt.dto.in.ReactionCreationDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reactions")
@AllArgsConstructor
public class ReactionRestController {
    @PostMapping("")
    @ResponseStatus(code= HttpStatus.CREATED)
    public Reaction create(@RequestBody ReactionCreationDTO reactionCreationDTO){
        throw new RuntimeException("Not implement");
    }
}
