package com.corleone.ingrediente.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Resumo de ingrediente utilizado na listagem.")
public class IngredienteResumoResponse {

    private Integer id;

    private String nome;

    private String unidade;

    private Boolean ativo;

}