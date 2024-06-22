package fr.esgi.calendrier_ybr_rpt.exception.gif;

public class GifFileFormatException extends RuntimeException {
    public GifFileFormatException(){
        super("Le fichier gif téléversé doit être au bon format : .gif, .Gif ou .GIF");
    }
}
