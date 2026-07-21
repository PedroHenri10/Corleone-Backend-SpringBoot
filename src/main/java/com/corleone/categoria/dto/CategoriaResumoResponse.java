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
    private Integer id;

    private String nome;

    private String descricao;

    private Boolean ativo = true;
}
