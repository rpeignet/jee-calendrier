package fr.esgi.calendrier_ybr_rpt.exception.jour;

public class JourNotFoundException extends RuntimeException{
    public JourNotFoundException(){
        super("Le jour n'a pas été trouvé");
    }
}
