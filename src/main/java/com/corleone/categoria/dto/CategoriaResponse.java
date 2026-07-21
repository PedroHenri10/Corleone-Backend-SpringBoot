package com.corleone.categoria.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados retornados de uma categoria.")
public class CategoriaResponse {

    private Integer id;

    private String nome;

    private String descricao;

    private Boolean ativo = true;

    private LocalDateTime dtCriacao;

    private LocalDateTime dtAtualizacao;
}
