package fr.esgi.calendrier_ybr_rpt.controller.rest.advice;

import fr.esgi.calendrier_ybr_rpt.exception.gif.UtilisateurCreditException;
import fr.esgi.calendrier_ybr_rpt.exception.typeReaction.TypeReactionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TypeReactionRestControllerAdvice {
    @ExceptionHandler(TypeReactionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleTypeReactionNotFoundException(TypeReactionNotFoundException e){
        return e.getMessage();
    }
}
