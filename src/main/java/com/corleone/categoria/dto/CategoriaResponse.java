package com.corleone.categoria.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados detalhados retornados de uma categoria.")
public class CategoriaResponse {

    @Schema(description = "Identificador único da categoria", example = "1")
    private Integer id;

    @Schema(description = "Nome da categoria", example = "Pizzas Doces")
    private String nome;

    @Schema(description = "Descrição detalhada da categoria", example = "Deliciosas pizzas com coberturas doces artesanais")
    private String descricao;

    @Schema(description = "Indica se a categoria está ativa no sistema", example = "true")
    private Boolean ativo = true;

    @Schema(description = "Data e hora de criação do registro", example = "2026-10-22T10:18:00")
    private LocalDateTime dtCriacao;

    @Schema(description = "Data e hora da última atualização do registro", example = "2026-10-22T10:19:00")
    private LocalDateTime dtAtualizacao;
}
