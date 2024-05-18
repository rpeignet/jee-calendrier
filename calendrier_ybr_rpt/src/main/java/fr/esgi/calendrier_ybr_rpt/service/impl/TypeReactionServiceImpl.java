package fr.esgi.calendrier_ybr_rpt.service.impl;

import fr.esgi.calendrier_ybr_rpt.business.TypeReaction;
import fr.esgi.calendrier_ybr_rpt.exception.MissingParamException;
import fr.esgi.calendrier_ybr_rpt.exception.typeReaction.TypeReactionNotFoundException;
import fr.esgi.calendrier_ybr_rpt.repository.TypeReactionRepository;
import fr.esgi.calendrier_ybr_rpt.service.TypeReactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TypeReactionServiceImpl implements TypeReactionService {

    private TypeReactionRepository typeReactionRepository;

    @Override
    public List<TypeReaction> findAll() {
        return typeReactionRepository.findAll();
    }

    @Override
    public TypeReaction findById(Long id) {
        if(id != null){
            Optional<TypeReaction> typeReaction = typeReactionRepository.findById(id);
            if(typeReaction.isPresent()){
                return typeReaction.get();
            }else{
                throw new TypeReactionNotFoundException();
            }
        }else{
            throw new MissingParamException();
        }
    }
}
