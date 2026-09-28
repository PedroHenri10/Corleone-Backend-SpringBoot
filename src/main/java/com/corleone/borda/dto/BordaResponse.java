package com.corleone.borda.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados completos da borda.")
public class BordaResponse {

    @Schema(description = "Identificador da borda.", example = "1")
    private Integer id;

    @Schema(description = "Nome da borda.", example = "Catupiry")
    private String nome;

    @Schema(description = "Preço adicional da borda.", example = "8.50")
    private BigDecimal preco;

    @Schema(description = "Indica se a borda está ativa.", example = "true")
    private Boolean ativo;
}