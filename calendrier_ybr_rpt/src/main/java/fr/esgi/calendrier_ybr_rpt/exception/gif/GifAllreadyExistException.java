package fr.esgi.calendrier_ybr_rpt.exception.gif;

// TODO : le nommage est pas terrible
public class GifAllreadyExistException extends RuntimeException {
    public GifAllreadyExistException(){
        super("Un gif a déjà été placer sur ce jour");
    }
}
