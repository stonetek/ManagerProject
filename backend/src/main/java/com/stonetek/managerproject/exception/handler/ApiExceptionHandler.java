package com.stonetek.managerproject.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.stonetek.managerproject.exception.EntityNotFoundException;

public class ApiExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> handlerObjectNotFoundException(EntityNotFoundException ex) {
        StandardError standardError = new StandardError(
                System.currentTimeMillis(),
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ValidationError validationError = new ValidationError(
                System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(),
                "Error na validação dos campos!");
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(fieldError -> {
                    validationError.addError(fieldError.getField(), fieldError.getDefaultMessage());
                });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationError);
    }
}
