package fr.esgi.calendrier_ybr_rpt.mapper;

import fr.esgi.calendrier_ybr_rpt.business.Utilisateur;
import fr.esgi.calendrier_ybr_rpt.dto.in.UtilisateurCreationDTO;
import fr.esgi.calendrier_ybr_rpt.dto.out.UtilisateurDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    componentModel = MappingConstants.ComponentModel.SPRING
)
public interface UtilisateurMapper {
    Utilisateur toEntity(UtilisateurCreationDTO utilisateurDTO);

    UtilisateurDTO toDTO(Utilisateur utilisateur);
}
