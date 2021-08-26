package com.example.abnerlucss.passagem.exception;

public class DeleteException extends Exception {

    public DeleteException(String message) {
        super(message);
    }

    public DeleteException(String message, Exception e) {
        super(message, e);
    }


}
