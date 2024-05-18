package fr.esgi.calendrier_ybr_rpt.exception.utilisateur;

public class ThemeNotFoundException extends RuntimeException {
    public ThemeNotFoundException(){
        super("Theme non trouvé !");
    }
}
