package fr.esgi.calendrier_ybr_rpt.mapper;

import fr.esgi.calendrier_ybr_rpt.business.Reaction;
import fr.esgi.calendrier_ybr_rpt.dto.in.ReactionCreationDTO;
import fr.esgi.calendrier_ybr_rpt.service.GifService;
import fr.esgi.calendrier_ybr_rpt.service.TypeReactionService;
import fr.esgi.calendrier_ybr_rpt.service.UtilisateurService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {GifService.class, TypeReactionService.class, UtilisateurService.class}
)
public interface ReactionMapper {

    @Mapping(source = "idGif", target = "gif")
    @Mapping(source = "idTypeReaction", target = "typeReaction")
    @Mapping(source = "idUtilisateur", target = "utilisateur")
    public Reaction toEntity(ReactionCreationDTO reactionCreationDTO);
}
