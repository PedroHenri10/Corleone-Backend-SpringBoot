package com.corleone.categoria.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Resumo de categoria utilizado na listagem.")
public class CategoriaResumoResponse {

    @Schema(description = "Identificador da categoria", example = "1")
    private Integer id;

    @Schema(description = "Nome da categoria", example = "Pizzas Doces")
    private String nome;

    @Schema(description = "Descrição detalhada da categoria", example = "Deliciosas pizzas com coberturas doces artesanais", )
    private String descricao;

    @Schema(description = "Indica se a categoria está ativa no sistema", example = "true")
    private Boolean ativo = true;
}
