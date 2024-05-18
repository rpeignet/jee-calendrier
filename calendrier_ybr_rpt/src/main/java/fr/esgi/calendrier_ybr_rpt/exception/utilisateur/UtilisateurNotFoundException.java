package fr.esgi.calendrier_ybr_rpt.exception.utilisateur;

public class UtilisateurNotFoundException extends RuntimeException{
    public UtilisateurNotFoundException(){
        super("L'utilisateur n'a pas été trouvé");
    }
}
