package com.corleone.exceptionhandler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorEnum {

    ERRO_GENERICO(
            HttpStatus.INTERNAL_SERVER_ERROR,
            1000,
            "Erro interno do sistema"
    ),

    REQUEST_INVALIDO(
            HttpStatus.BAD_REQUEST,
            1001,
            "Dados inválidos"
    ),

    RECURSO_NAO_ENCONTRADO(
            HttpStatus.NOT_FOUND,
            1002,
            "Recurso não encontrado"
    ),

    REGRA_NEGOCIO(
            HttpStatus.BAD_REQUEST,
            1003,
            "Regra de negócio violada"
    ),

    USUARIO_NAO_ENCONTRADO(
            HttpStatus.NOT_FOUND,
            2001,
            "Usuário não encontrado"
    ),

    CARGO_NAO_ENCONTRADO(
            HttpStatus.NOT_FOUND,
            2002,
            "Cargo não encontrado"
    );

    private final HttpStatus httpStatus;
    private final Integer errorCode;
    private final String errorMessage;

    ErrorEnum(
            HttpStatus httpStatus,
            Integer errorCode,
            String errorMessage
    ) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
