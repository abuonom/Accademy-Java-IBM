package com.sistemi.informativi.controller;

import com.sistemi.informativi.exception.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/*
Grazie all'annotation @RestControllerAdvice questa classe a runtime sta in ascolto
su eventuali eccezioni che si verificano nei RestController e possiamo chiedere che,
al verificarsi di una o più eccezioni venga restituito un JSON Custom


 */

@RestControllerAdvice
public class ExceptionAdvice {
    /*
    Tramite l'annotation @ExceptionHandler chiediamo che, al verificarsi dell'eccezione
    MethodArgumentNotValidException venga eseguito il metodo corrispettivo
    Nel caso specifico, restituiamo un JSON custom con le nostre specifiche
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    public ErrorMessage notValidExceptionHandler(MethodArgumentNotValidException ex, WebRequest request) {

        ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), new Date(),
                "code must of be of 4 characters", request.getDescription(false));
        return message;
    }
}
