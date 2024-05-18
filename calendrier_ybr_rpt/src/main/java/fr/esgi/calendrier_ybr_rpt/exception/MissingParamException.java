package fr.esgi.calendrier_ybr_rpt.exception;

public class MissingParamException extends RuntimeException{
    public MissingParamException(){
        super("Paramètre manquant.");
    }
}
