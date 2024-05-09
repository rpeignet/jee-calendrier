package fr.esgi.calendrier_ybr_rpt.dto.out;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GifPlacementDTO {
    public Long idUtilisateur;
    public Long idJour;
    public LocalDate date;

    public GifPlacementDTO(Long idUtilisateur, Long idJour, LocalDate date) {
        this.idUtilisateur = idUtilisateur;
        this.idJour = idJour;
        this.date = date;
    }
}
