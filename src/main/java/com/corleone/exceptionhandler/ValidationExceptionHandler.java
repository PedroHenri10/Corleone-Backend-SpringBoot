package com.corleone.exceptionhandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse<List<FieldErrorResponse>>>
    handleValidation(MethodArgumentNotValidException ex) {

        List<FieldErrorResponse> erros =
                ex.getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .map(error ->
                                new FieldErrorResponse(
                                        error.getField(),
                                        error.getDefaultMessage()
                                )
                        )
                        .toList();

        return ResponseEntity.badRequest()
                .body(
                        ErrorResponse.<List<FieldErrorResponse>>builder()
                                .codigo(1001)
                                .mensagem("Dados inválidos")
                                .detalhes(erros)
                                .build()
                );
    }

    public record FieldErrorResponse(
            String campo,
            String mensagem
    ) {
    }
}
