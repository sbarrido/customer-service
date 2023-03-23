package edu.iu.c322.customerservice.handler;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

   @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<?> handleException(IllegalStateException ise) {
        return ResponseEntity.badRequest().body(ise.getMessage());
    }
}
