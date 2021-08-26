package com.example.abnerlucss.passagem.exceptions;

public class CreateException extends Exception{
    public CreateException(String message) {
        super(message);
    }

    public CreateException(String message, Throwable cause) {
        super(message, cause);
    }
}
