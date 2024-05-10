package fr.esgi.calendrier_ybr_rpt.mapper;

import fr.esgi.calendrier_ybr_rpt.business.Gif;
import fr.esgi.calendrier_ybr_rpt.dto.in.GifCreationDTO;
import fr.esgi.calendrier_ybr_rpt.service.GifService;
import fr.esgi.calendrier_ybr_rpt.service.JourService;
import fr.esgi.calendrier_ybr_rpt.service.UtilisateurService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {GifService.class, UtilisateurService.class, JourService.class}
)
public interface GifMapper {
    @Mapping(target = "utilisateur", source = "idUtilisateur")
    @Mapping(target = "jour", source = "idJour")
    public Gif toEntity(GifCreationDTO gifCreationDTO);
}
