package com.corleone.exceptionhandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse<?>> handleException(
            Exception ex
    ) {
        ErrorEnum error = ErrorEnum.ERRO_GENERICO;

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