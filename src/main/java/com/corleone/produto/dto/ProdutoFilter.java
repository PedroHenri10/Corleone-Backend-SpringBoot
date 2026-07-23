package com.corleone.produto.dto;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoFilter {

    @Parameter(description = "Nome do produto", example = "Pizza")
    private String nome;

    @Parameter(description = "Código do produto", example = "PIZ001")
    private String codigo;

    @Parameter(description = "ID da categoria", example = "1")
    private Integer categoriaId;

    @Parameter(description = "ID do fornecedor", example = "2")
    private Integer fornecedorId;

    @Parameter(description = "Preço mínimo", example = "30.00")
    private BigDecimal precoMinimo;

    @Parameter(description = "Preço máximo", example = "120.00")
    private BigDecimal precoMaximo;

    @Parameter(description = "Produto ativo", example = "true")
    private Boolean ativo;
}