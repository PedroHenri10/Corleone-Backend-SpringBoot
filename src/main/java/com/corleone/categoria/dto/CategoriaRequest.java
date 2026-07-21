package com.corleone.categoria.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "dados para cadastro e atualizacão de uma categoria")
public class CategoriaRequest {

    @NotBlank
    @Size(max= 100)
    @Schema(description = "Nome.", example = "Pizzas doces", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nome;

    @Size(max= 255)
    @Schema(description = "Descrição.", example ="Cayegorias destinadas ás pizzas doces")
    private String descricao;

}
