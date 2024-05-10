package fr.esgi.calendrier_ybr_rpt.mapper;

import fr.esgi.calendrier_ybr_rpt.business.Utilisateur;
import fr.esgi.calendrier_ybr_rpt.dto.in.UtilisateurCreationDTO;
import fr.esgi.calendrier_ybr_rpt.dto.out.UtilisateurDTO;
import fr.esgi.calendrier_ybr_rpt.repository.ThemeRepository;
import fr.esgi.calendrier_ybr_rpt.service.ThemeService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    componentModel = MappingConstants.ComponentModel.SPRING,
    uses = {ThemeService.class}
)
public interface UtilisateurMapper {

    @Mapping(source = "idTheme", target = "theme")
    Utilisateur toEntity(UtilisateurCreationDTO utilisateurDTO);

    UtilisateurDTO toDTO(Utilisateur utilisateur);
}
