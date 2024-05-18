package fr.esgi.calendrier_ybr_rpt.service;

import fr.esgi.calendrier_ybr_rpt.business.TypeReaction;

import java.util.List;

public interface TypeReactionService {
    public List<TypeReaction> findAll();

    public TypeReaction findById(Long id);
}
