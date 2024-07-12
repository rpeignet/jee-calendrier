package fr.esgi.calendrier_ybr_rpt.controller.rest.advice;

import fr.esgi.calendrier_ybr_rpt.exception.utilisateur.ThemeNotFoundException;
import fr.esgi.calendrier_ybr_rpt.exception.utilisateur.UtilisateurNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UtilisateurRestControllerAdvice {
    @ExceptionHandler(ThemeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleThemeNotFindException(ThemeNotFoundException e){
        return e.getMessage();
    }

    @ExceptionHandler(UtilisateurNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleUtilisateurNotFoundException(UtilisateurNotFoundException e){
        return e.getMessage();
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleValidationException(ValidationException e){
        return e.getMessage();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleIllegalArgumentException(IllegalArgumentException e){
        return "L'utilisateur ne doit pas déjà exister.";
    }
}
