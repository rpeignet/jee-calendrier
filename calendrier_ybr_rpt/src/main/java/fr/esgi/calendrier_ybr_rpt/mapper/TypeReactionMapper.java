package fr.esgi.calendrier_ybr_rpt.mapper;

import fr.esgi.calendrier_ybr_rpt.business.TypeReaction;
import fr.esgi.calendrier_ybr_rpt.dto.out.TypeReactionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface TypeReactionMapper {
    TypeReactionDTO toDTO(TypeReaction typeReaction);
}
