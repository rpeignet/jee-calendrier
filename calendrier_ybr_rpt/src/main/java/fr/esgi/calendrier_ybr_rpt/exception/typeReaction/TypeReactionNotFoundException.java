package fr.esgi.calendrier_ybr_rpt.exception.typeReaction;

public class TypeReactionNotFoundException extends RuntimeException{
    public TypeReactionNotFoundException(){
        super("Le type réaction n'a pas été trouvé !");
    }
}
