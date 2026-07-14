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

        return ResponseEntity.internalServerError()
                .body(
                        ErrorResponse.builder()
                                .codigo(1000)
                                .mensagem("Erro interno do sistema")
                                .build()
                );
    }
}