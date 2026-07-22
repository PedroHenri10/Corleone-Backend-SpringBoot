package com.corleone.sabor.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Resumo utilizado na listagem de sabores.")
public class SaborResumoResponse {

    @Schema(example = "1")
    private Integer id;

    @Schema(example = "Calabresa")
    private String nome;

    @Schema(example = "true")
    private Boolean ativo;
}
