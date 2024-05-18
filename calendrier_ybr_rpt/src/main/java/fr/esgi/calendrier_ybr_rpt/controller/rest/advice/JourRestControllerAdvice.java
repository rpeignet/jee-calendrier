package fr.esgi.calendrier_ybr_rpt.controller.rest.advice;

import fr.esgi.calendrier_ybr_rpt.exception.jour.JourNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class JourRestControllerAdvice{
    @ExceptionHandler(JourNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleJourNotFoundException(JourNotFoundException e){
        return e.getMessage();
    }
}
