package com.corleone.produto.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Ingrediente utilizado no produto.")
public class ProdutoIngredienteRequest {

    @NotNull
    @Schema(example = "3")
    private Integer ingredienteId;

    @NotNull
    @DecimalMin("0.001")
    @Schema(example = "0.250")
    private BigDecimal quantidade;

    @NotBlank
    @Schema(example = "KG")
    private String unidade;

}