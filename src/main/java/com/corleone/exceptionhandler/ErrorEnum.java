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
    ),
    CREDENCIAIS_INVALIDAS(
            HttpStatus.UNAUTHORIZED,
            2003,
            "Credenciais inválidas"
    ),
    CPF_INVALIDO(
            HttpStatus.BAD_REQUEST,
            2006,
            "O CPF informado é inválido"
    ),
    CPF_JA_CADASTRADO(HttpStatus.CONFLICT,
            2004,
            "O CPF informado já está cadastrado"
    ),
    EMAIL_JA_CADASTRADO(
            HttpStatus.CONFLICT,
            2005,
            "O e-mail informado já está cadastrado"
    ),
    EMAIL_INVALIDO(
            HttpStatus.BAD_REQUEST,
            2007,
            "O e-mail informado é inválido"
    ),
    CARGO_INATIVO(
            HttpStatus.BAD_REQUEST,
            2008,
            "O cargo informado está inativo"
    ),
    FUNCIONARIO_NAO_ENCONTRADO(
            HttpStatus.NOT_FOUND,
            2009,
            "Funcionário não encontrado"
    ),
    ENDERECO_NAO_ENCONTRADO(
            HttpStatus.NOT_FOUND,
            2010,
            "Endereço não encontrado"
    ), FUNCIONARIO_INATIVO(
            HttpStatus.UNPROCESSABLE_ENTITY,
            2011,
            "Funcionário já inativo"
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
