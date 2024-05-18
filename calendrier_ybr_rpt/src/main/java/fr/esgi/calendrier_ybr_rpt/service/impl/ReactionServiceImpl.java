package fr.esgi.calendrier_ybr_rpt.service.impl;

import fr.esgi.calendrier_ybr_rpt.business.Reaction;
import fr.esgi.calendrier_ybr_rpt.repository.ReactionRepository;
import fr.esgi.calendrier_ybr_rpt.service.ReactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReactionServiceImpl implements ReactionService {

    private ReactionRepository reactionRepository;

    @Override
    public Reaction save(Reaction reaction) {
        return reactionRepository.save(reaction);
    }
}
