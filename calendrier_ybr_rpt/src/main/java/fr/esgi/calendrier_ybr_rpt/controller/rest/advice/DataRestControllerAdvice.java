package fr.esgi.calendrier_ybr_rpt.controller.rest.advice;

import fr.esgi.calendrier_ybr_rpt.exception.MissingParamException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class DataRestControllerAdvice {
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    public List<String> traiterDonneesInvalides(ConstraintViolationException exception) {
        return exception.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toList();
    }

    @ExceptionHandler(MissingParamException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleMissingParamException(MissingParamException e){
        return e.getMessage();
    }
}
