package com.corleone.sabor.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados para cadastro e atualização de um sabor.")
public class SaborRequest {

    @NotBlank
    @Size(max = 100)
    @Schema(description = "Nome do sabor.", example = "Calabresa", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nome;

    @Size(max = 255)
    @Schema(description = "Descrição do sabor.", example = "Calabresa, cebola e mussarela.")
    private String descricao;
}