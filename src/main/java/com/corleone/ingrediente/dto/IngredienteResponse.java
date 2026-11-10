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

    @Schema(description = "Identificador do ingrediente.", example = "1")
    private Integer id;

    @Schema(description = "Nome do ingrediente.", example = "Mussarela")
    private String nome;

    @Schema(description = "Descrição do ingrediente.", example = "Queijo mussarela fatiado")
    private String descricao;

    @Schema(description = "Unidade de medida.", example = "KG")
    private String unidade;

    @Schema(description = "Custo unitário do ingrediente.", example = "28.50")
    private BigDecimal custoUnitario;

    @Schema(description = "Estoque mínimo recomendado.", example = "5.000")
    private BigDecimal estoqueMinimo;

    @Schema(description = "Indica se o ingrediente está ativo.", example = "true")
    private Boolean ativo;

    @Schema(description = "Data de criação do registro.", example = "2026-11-10T10:00:00")
    private LocalDateTime dataCriacao;

    @Schema(description = "Data da última atualização.", example = "2026-11-10T12:30:00")
    private LocalDateTime dataAtualizacao;
}