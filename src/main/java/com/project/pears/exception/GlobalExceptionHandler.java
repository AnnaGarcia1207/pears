package com.project.pears.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/*
Global exception handling

You can catch exceptions thrown by any controller and return a custom response.

Example: handle PersonNotFoundException or IllegalArgumentException globally.

Works with @ExceptionHandler

Inside a @ControllerAdvice class, you can annotate methods with @ExceptionHandler to specify which exception they handle.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handlePersonNotFound(PersonNotFoundException exception) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", "Person Not Found");
        body.put("message", exception.getMessage());
        body.put("status", HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
}
