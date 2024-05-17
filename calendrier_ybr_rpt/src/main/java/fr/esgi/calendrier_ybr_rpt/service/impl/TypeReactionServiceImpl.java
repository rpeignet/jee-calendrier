package fr.esgi.calendrier_ybr_rpt.service.impl;

import fr.esgi.calendrier_ybr_rpt.business.TypeReaction;
import fr.esgi.calendrier_ybr_rpt.repository.TypeReactionRepository;
import fr.esgi.calendrier_ybr_rpt.service.TypeReactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TypeReactionServiceImpl implements TypeReactionService {

    private TypeReactionRepository typeReactionRepository;

    @Override
    public List<TypeReaction> findAll() {
        return typeReactionRepository.findAll();
    }
}
