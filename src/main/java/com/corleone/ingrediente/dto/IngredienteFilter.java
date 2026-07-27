package com.corleone.ingrediente.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Filtros para pesquisa de ingredientes.")
public class IngredienteFilter {

    @Schema(example = "Queijo")
    private String nome;

    @Schema(example = "KG")
    private String unidade;

    @Schema(example = "true")
    private Boolean ativo;

}