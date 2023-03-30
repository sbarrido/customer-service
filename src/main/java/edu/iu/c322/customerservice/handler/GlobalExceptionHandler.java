package edu.iu.c322.customerservice.handler;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

   @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<?> handleException(IllegalStateException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleException(MethodArgumentNotValidException ex) {
        String errMessage = ex.getBindingResult().getFieldErrors().stream().map(error ->
                error.getDefaultMessage()).collect(Collectors.joining(", "));
        return ResponseEntity.badRequest().body(errMessage);
    }
}
