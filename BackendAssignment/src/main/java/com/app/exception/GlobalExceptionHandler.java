package com.app.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice//This annotation makes this class a global exception handler for the entire application.
                 //Any exceptions thrown by controllers are handled here if they match the specified exceptions.
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)//This annotation specifies that the handleValidationExceptions method will handle 
    // MethodArgumentNotValidException.
    // MethodArgumentNotValidException occurs when a request contains invalid data that doesn’t meet the validation constraints defined in the model
    // (e.g., @NotNull, @Size).
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        System.out.println(ex);
        System.out.println("space");
        System.out.println(ex.getBindingResult());
        System.out.println("space");
        System.out.println(ex.getBindingResult().getFieldErrors());
        ex.getBindingResult().getFieldErrors().forEach(error ->//ex.getBindingResult().getFieldErrors() retrieves a list of field errors.
            errors.put(error.getField(), error.getDefaultMessage())
        );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}

