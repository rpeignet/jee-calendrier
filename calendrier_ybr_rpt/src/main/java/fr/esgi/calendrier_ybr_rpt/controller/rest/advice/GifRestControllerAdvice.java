package fr.esgi.calendrier_ybr_rpt.controller.rest.advice;

import fr.esgi.calendrier_ybr_rpt.exception.MissingParamException;
import fr.esgi.calendrier_ybr_rpt.exception.gif.GifAllreadyExistException;
import fr.esgi.calendrier_ybr_rpt.exception.gif.GifDownloadException;
import fr.esgi.calendrier_ybr_rpt.exception.gif.GifNotFoundException;
import fr.esgi.calendrier_ybr_rpt.exception.gif.UtilisateurCreditException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GifRestControllerAdvice {
    @ExceptionHandler(UtilisateurCreditException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleUtilisateurCreditException(UtilisateurCreditException e){
        return e.getMessage();
    }

    @ExceptionHandler(GifAllreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleGifAllreadyExistException(GifAllreadyExistException e){
        return e.getMessage();
    }

    @ExceptionHandler(GifNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleGifNotFoundException(GifNotFoundException e){
        return e.getMessage();
    }

    @ExceptionHandler(GifDownloadException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleGifDownloadException(GifDownloadException e){
        return e.getMessage();
    }
}