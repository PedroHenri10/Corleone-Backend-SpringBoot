package com.corleone.ingrediente.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados retornados de um ingrediente.")
public class IngredienteResponse {

    private Integer id;

    private String nome;

    private String descricao;

    private String unidade;

    private BigDecimal custoUnitario;

    private BigDecimal estoqueMinimo;

    private Boolean ativo;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

}