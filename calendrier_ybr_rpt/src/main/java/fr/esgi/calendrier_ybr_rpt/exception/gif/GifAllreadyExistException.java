package fr.esgi.calendrier_ybr_rpt.exception.gif;

public class GifAllreadyExistException extends RuntimeException {
    public GifAllreadyExistException(){
        super("Un gif a déjà été placer sur ce jour");
    }
}
