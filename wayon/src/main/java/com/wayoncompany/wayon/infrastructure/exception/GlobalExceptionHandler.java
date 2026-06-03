package com.wayoncompany.wayon.infrastructure.exception;

import com.wayoncompany.wayon.domain.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(
            BusinessException.class)
    public ResponseEntity<String>
    handleBusinessException(
            BusinessException exception) {

        return ResponseEntity
                .badRequest()
                .body(
                        exception.getMessage()
                );
    }

    @ExceptionHandler(
            MethodArgumentNotValidException.class)
    public ResponseEntity<String>
    handleValidationException(
            MethodArgumentNotValidException exception) {

        String message =
                Objects.requireNonNull(exception
                                .getBindingResult()
                                .getFieldError())
                        .getDefaultMessage();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(message);
    }

    @ExceptionHandler(
            Exception.class)
    public ResponseEntity<String>
    handleGenericException(
            Exception exception) {

        return ResponseEntity
                .status(
                        HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        exception.getMessage()
                );
    }
}
