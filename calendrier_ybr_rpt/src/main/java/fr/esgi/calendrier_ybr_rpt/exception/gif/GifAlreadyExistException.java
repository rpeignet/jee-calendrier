package fr.esgi.calendrier_ybr_rpt.exception.gif;

public class GifAlreadyExistException extends RuntimeException {
    public GifAlreadyExistException(){
        super("Un gif a déjà été placer sur ce jour");
    }
}
