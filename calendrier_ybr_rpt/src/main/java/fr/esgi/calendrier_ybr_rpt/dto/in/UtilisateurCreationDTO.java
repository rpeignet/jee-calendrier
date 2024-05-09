package fr.esgi.calendrier_ybr_rpt.dto.in;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UtilisateurCreationDTO {
    public String nom;
    public String prenom;
    public String email;
    public String motDePasse;
    @NotNull(message = "L'utilisateur doit posséder un theme")
    public Long idTheme;
}
