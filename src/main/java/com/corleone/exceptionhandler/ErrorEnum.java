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
    ),
    CARGO_JA_CADASTRADO(
            HttpStatus.CONFLICT,
            2012,
            "Cargo já cadastrado no sistema"
    ),
    LOGIN_JA_CADASTRADO(
            HttpStatus.CONFLICT,
            2013,
            "login já cadastrado no sistema"
    ),
    ROLE_NAO_ENCONTRADA(
            HttpStatus.NOT_FOUND,
            2014,
            "Uma ou mais Roles não foram encontradas no sistema"
    ),
    USUARIO_INATIVO(
            HttpStatus.UNPROCESSABLE_ENTITY,
            2015,
            "Usuário já inativo"
    ),
    FORNECEDOR_NAO_ENCONTRADO(
            HttpStatus.NOT_FOUND,
            2016,
            "Fornecedor não encontrado"
    ),
    CNPJ_JA_CADASTRADO(HttpStatus.CONFLICT,
            2017,
            "O CNPJ informado já está cadastrado"
    ),
    FORNECEDOR_INATIVO(
            HttpStatus.UNPROCESSABLE_ENTITY,
            2018,
            "Fornecedor já inativo"
    ),
    CATEGORIA_NAO_ENCONTRADA(
            HttpStatus.NOT_FOUND,
            2019,
            "Categoria não encontrada"
    ),

    CATEGORIA_JA_CADASTRADA(
            HttpStatus.BAD_REQUEST,
            2020,
            "Já existe uma categoria com esse nome"
    ),
    CATEGORIA_INATIVO(
            HttpStatus.BAD_REQUEST,
            2021,
            "A categoria informado já está inativa"
    ),
    CLIENTE_NAO_ENCONTRADO(
            HttpStatus.NOT_FOUND,
            2022,
            "Cliente não encontrado"
    ),
    CLIENTE_INATIVO(
            HttpStatus.BAD_REQUEST,
            2023,
            "O cliente informado já está inativo"
    ),
    SABOR_NAO_ENCONTRADO(
            HttpStatus.NOT_FOUND,
            2024,
            "Sabor não encontrado"
    ),

    SABOR_JA_CADASTRADO(
            HttpStatus.BAD_REQUEST,
            2025,
            "Já existe um sabor com esse nome"
    ),

    SABOR_INATIVO(
            HttpStatus.BAD_REQUEST,
            2026,
            "O sabor informado já está inativo"
    ),
    TAMANHO_NAO_ENCONTRADO(
            HttpStatus.NOT_FOUND,
            2027,
            "Tamanho não encontrado"
    ),

    TAMANHO_JA_CADASTRADO(
            HttpStatus.CONFLICT,
            2028,
            "Já existe um tamanho cadastrado com esse nome"
    ),

    TAMANHO_INATIVO(
            HttpStatus.BAD_REQUEST,
            2029,
            "O tamanho informado já está inativo"
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
