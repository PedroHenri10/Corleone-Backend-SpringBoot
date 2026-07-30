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
            HttpStatus.UNPROCESSABLE_CONTENT,
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
            HttpStatus.UNPROCESSABLE_CONTENT,
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
            HttpStatus.UNPROCESSABLE_CONTENT,
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
            HttpStatus.UNPROCESSABLE_CONTENT,
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
            HttpStatus.UNPROCESSABLE_CONTENT,
            2021,
            "A categoria informado já está inativa"
    ),
    CLIENTE_NAO_ENCONTRADO(
            HttpStatus.NOT_FOUND,
            2022,
            "Cliente não encontrado"
    ),
    CLIENTE_INATIVO(
            HttpStatus.UNPROCESSABLE_CONTENT,
            2023,
            "O cliente informado já está inativo"
    ),
    SABOR_NAO_ENCONTRADO(
            HttpStatus.NOT_FOUND,
            2024,
            "Sabor não encontrado"
    ),

    SABOR_JA_CADASTRADO(
            HttpStatus.UNPROCESSABLE_CONTENT,
            2025,
            "Já existe um sabor com esse nome"
    ),

    SABOR_INATIVO(
            HttpStatus.UNPROCESSABLE_CONTENT,
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
            HttpStatus.UNPROCESSABLE_CONTENT,
            2029,
            "O tamanho informado já está inativo"
    ),
    BORDA_NAO_ENCONTRADA(
            HttpStatus.NOT_FOUND,
            2030,
            "Borda não encontrada"
    ),

    BORDA_JA_CADASTRADA(
            HttpStatus.CONFLICT,
            2031,
            "Já existe uma borda cadastrada com esse nome"
    ),

    BORDA_INATIVA(
            HttpStatus.BAD_REQUEST,
            2032,
            "A borda informada já está inativa"
    ),
    PRODUTO_NAO_ENCONTRADO(
            HttpStatus.NOT_FOUND,
            2033,
            "Produto não encontrado"
    ),

    PRODUTO_JA_CADASTRADO(
            HttpStatus.CONFLICT,
            2034,
            "Já existe um produto cadastrado com esse código"
    ),
    PRODUTO_INATIVO(
            HttpStatus.UNPROCESSABLE_CONTENT,
            2035,
            "O produto informado já está inativo"
    ),
    INGREDIENTE_NAO_ENCONTRADO(
            HttpStatus.NOT_FOUND,
            2036,
            "Ingrediente não encontrado"
    ),
    INGREDIENTE_INATIVO(
            HttpStatus.UNPROCESSABLE_CONTENT,
            2037,
            "Ingrediente informado Inativo"
    ),
    INGREDIENTE_JA_CADASTRADO(
            HttpStatus.CONFLICT,
            2038,
            "Já existe um ingrediente cadastrado com esse nome"
    ),
    ESTOQUE_INSUFICIENTE(
            HttpStatus.BAD_REQUEST,
            2039,
            "Quantidade insuficiente em estoque"
    ),
    ESTOQUE_NAO_ENCONTRADO(
            HttpStatus.NOT_FOUND,
            2040,
            "estoque não encontrado."
    ),
    ESTOQUE_INGREDIENTE_INSUFICIENTE(
            HttpStatus.BAD_REQUEST,
            2041,
            "Quantidade ingrediente insuficiente em estoque"
    ),
    MOVIMENTO_INGREDIENTE_NAO_ENCONTRADO(
            HttpStatus.NOT_FOUND,
            2042,
            "Movimento estoque não encontrado."
    ),
    ENTREGA_NAO_ENCONTRADA(
            HttpStatus.NOT_FOUND,
            2043,
            "Entrega não encontrada"
    ),

    PEDIDO_JA_POSSUI_ENTREGA(
            HttpStatus.CONFLICT,
            2044,
            "O pedido já possui uma entrega cadastrada"
    ),
    PEDIDO_NAO_ENCONTRADO(
            HttpStatus.NOT_FOUND,
            2045,
            "Pedido não encontrado"
    ),
    MESA_NAO_ENCONTRADO(
            HttpStatus.NOT_FOUND,
            2046,
            "Mesa não encontrada"
    ),
    MESA_JA_CADASTRADA(
            HttpStatus.CONFLICT,
            2047,
            "Já existe uma mesa com esse número."
    ),
    MESA_INATIVA(
            HttpStatus.UNPROCESSABLE_CONTENT,
            2048,
            "A operação não pode ser realizada porque a mesa está inativa."
    ),
    MESA_NAO_DISPONIVEL(
            HttpStatus.UNPROCESSABLE_CONTENT,
            2049,
            "A mesa não está livre para a operação solicitada."
    ),
    MESA_NAO_OCUPADA(
            HttpStatus.UNPROCESSABLE_CONTENT,
            2050,
            "Não é possível fechar uma mesa que não está ocupada."
    ),
    MESA_NAO_RESERVADA(
            HttpStatus.UNPROCESSABLE_CONTENT,
            2051,
            "Não é possível cancelar ou utilizar uma reserva inexistente."
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
