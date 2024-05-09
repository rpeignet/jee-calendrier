package fr.esgi.calendrier_ybr_rpt.controller.rest;

import fr.esgi.calendrier_ybr_rpt.exception.ThemeNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class UtilisateurRestControllerAdvice {
    @ExceptionHandler(ThemeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleThemeNotFindException(ThemeNotFoundException e){
        return e.getMessage();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    public List<String> traiterDonneesInvalides(ConstraintViolationException exception) {
        return exception.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toList();
    }
}
