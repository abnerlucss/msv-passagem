package com.example.abnerlucss.passagem.controller.handler;

import com.example.abnerlucss.passagem.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@SuppressWarnings("unused")
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CreateException.class)
    public ResponseEntity<ErrorObject> createError(CreateException e) {
        ErrorObject errorObject = new ErrorObject(LocalDateTime.now(), e.getMessage(), e.getCause().toString());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorObject);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorObject> notFoundError(NotFoundException e) {
        ErrorObject errorObject = new ErrorObject(LocalDateTime.now(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorObject);
    }

    @ExceptionHandler(UpdateException.class)
    public ResponseEntity<ErrorObject> updateError(UpdateException e) {
        ErrorObject errorObject = new ErrorObject(LocalDateTime.now(), e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorObject);
    }

    @ExceptionHandler(DeleteException.class)
    public ResponseEntity<ErrorObject> deleteError(DeleteException e) {
        ErrorObject errorObject = new ErrorObject(LocalDateTime.now(), e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorObject);
    }

    @ExceptionHandler(ListException.class)
    public ResponseEntity<ErrorObject> listError(ListException e) {
        ErrorObject errorObject = new ErrorObject(LocalDateTime.now(), e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorObject);
    }

    @ExceptionHandler(ConvertException.class)
    public ResponseEntity<ErrorObject> convertError(ConvertException e) {
        ErrorObject errorObject = new ErrorObject(LocalDateTime.now(), e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorObject);
    }

}
