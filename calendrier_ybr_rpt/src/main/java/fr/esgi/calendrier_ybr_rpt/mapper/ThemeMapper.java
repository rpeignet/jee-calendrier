package fr.esgi.calendrier_ybr_rpt.mapper;

import fr.esgi.calendrier_ybr_rpt.business.Theme;
import fr.esgi.calendrier_ybr_rpt.dto.out.ThemeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface ThemeMapper {
    ThemeDTO toDTO(Theme theme);
}
