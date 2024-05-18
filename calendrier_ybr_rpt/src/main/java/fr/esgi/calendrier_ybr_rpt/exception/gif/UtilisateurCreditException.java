package fr.esgi.calendrier_ybr_rpt.exception.gif;

public class UtilisateurCreditException extends RuntimeException{
    public UtilisateurCreditException(){
        super("L'utilisateur ne dispose pas d'assez de point pour placer un gif");
    }
}
