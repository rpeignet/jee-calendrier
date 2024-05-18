package fr.esgi.calendrier_ybr_rpt.exception.gif;

public class GifNotFoundException extends RuntimeException{
    public GifNotFoundException(){
        super("Le gif n'existe pas");
    }
}
