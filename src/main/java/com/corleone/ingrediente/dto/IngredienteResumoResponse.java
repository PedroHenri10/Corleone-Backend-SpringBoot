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

    @Schema(description = "Identificador do ingrediente.", example = "1")
    private Integer id;

    @Schema(description = "Nome do ingrediente.", example = "Mussarela")
    private String nome;

    @Schema(description = "Unidade de medida.", example = "KG")
    private String unidade;

    @Schema(description = "Indica se o ingrediente está ativo.", example = "true")
    private Boolean ativo;
}