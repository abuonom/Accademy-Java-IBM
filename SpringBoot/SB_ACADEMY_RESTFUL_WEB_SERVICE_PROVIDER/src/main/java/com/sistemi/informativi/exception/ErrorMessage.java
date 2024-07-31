package com.sistemi.informativi.exception;

import java.util.Date;


/*
Costruzione di un oggetto che venga successivamente convertito dal Jackson Object
Mapper in un JSON contenente come proprietà:
statusCode dell'errore
data dell'errore
messaggio custom dell'errore
descrizione dell'errore
 */

public class ErrorMessage {
    private int statusCode;
    private Date date;
    private String message;
    private String description;

    public ErrorMessage(int statusCode, Date date, String message, String description) {
        this.statusCode = statusCode;
        this.date = date;
        this.message = message;
        this.description = description;
    }

    public ErrorMessage() {

    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
