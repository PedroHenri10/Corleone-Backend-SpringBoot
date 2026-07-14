package com.corleone.exceptionhandler;

import com.corleone.exception.BaseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse<?>> handleBaseException(
            BaseException ex
    ) {

        ErrorEnum error = ex.getErrorEnum();

        return ResponseEntity
                .status(error.getHttpStatus())
                .body(
                        ErrorResponse.builder()
                                .codigo(error.getErrorCode())
                                .mensagem(error.getErrorMessage())
                                .build()
                );
    }
}