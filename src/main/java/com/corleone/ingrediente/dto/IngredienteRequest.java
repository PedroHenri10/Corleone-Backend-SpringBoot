package com.corleone.ingrediente.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados para cadastro e atualização de um ingrediente.")
public class IngredienteRequest {

    @NotBlank
    @Size(max = 120)
    @Schema(description = "Nome do ingrediente.", example = "Mussarela")
    private String nome;

    @Size(max = 255)
    @Schema(description = "Descrição.", example = "Queijo mussarela fatiado")
    private String descricao;

    @NotBlank
    @Size(max = 20)
    @Schema(description = "Unidade de medida.", example = "KG")
    private String unidade;

    @NotNull
    @DecimalMin("0.00")
    @Schema(description = "Custo unitário.", example = "28.50")
    private BigDecimal custoUnitario;

    @DecimalMin("0.00")
    @Schema(description = "Estoque mínimo.", example = "5.000")
    private BigDecimal estoqueMinimo;

}