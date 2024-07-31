package com.sistemi.informativi.library_web_service_provider.controller;

import com.sistemi.informativi.library_web_service_provider.exception.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import java.util.Date;

@RestControllerAdvice
public class ExceptionAdvice {
    /*
     * Tramite l'annotation @ExceptionHandler chiediamo che,
     * al verificarsi dell'eccezione MethodArgumentNotValidException,
     * venga eseguito il metodo notValidExceptionHandler.
     * Nel caso specifico il metodo notValidExceptionHandler
     * si occupa di restituire un Oggetto ErrorMessage che verrà
     * convertito in un json con messaggio custom
     *
     *
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    public ErrorMessage notValidExceptionHandler(Exception ex, WebRequest request) {

        ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), new Date(),
                "code must of be of 4 characters", "wrong code");

        return message;

    }


}
