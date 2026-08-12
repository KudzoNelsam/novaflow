package com.novalabs.novaflow.project.handler;


import com.novalabs.novaflow.project.exceptions.ProjectAlreadyExistException;
import com.novalabs.novaflow.rest.dto.ErrorFieldResponse;
import com.novalabs.novaflow.rest.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Gère une exception spécifique
    @ExceptionHandler(ProjectAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ProjectAlreadyExistException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                ex.getMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    // Gère les erreurs de validation (@Valid sur un DTO)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorFieldResponse> handleValidation(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        });

        ErrorFieldResponse errorsList = new ErrorFieldResponse(HttpStatus.BAD_REQUEST.value(), errors);
        return new ResponseEntity<>(errorsList, HttpStatus.BAD_REQUEST);
    }
}
