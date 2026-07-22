package com.corleone.sabor.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados completos do sabor.")
public class SaborResponse {

    @Schema(example = "1")
    private Integer id;

    @Schema(example = "Calabresa")
    private String nome;

    @Schema(example = "Calabresa, cebola e mussarela.")
    private String descricao;

    @Schema(example = "true")
    private Boolean ativo;
}