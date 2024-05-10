package fr.esgi.calendrier_ybr_rpt.dto.in;

import lombok.Data;

@Data
public class GifCreationDTO {
    public Long idUtilisateur;
    public Long idJour;
    public String urlFichier;
    public String legende;
}
