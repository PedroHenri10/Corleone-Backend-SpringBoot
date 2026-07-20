package com.corleone.cargo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados para cadastro e atualização de um cargo.")
public class CargoRequest {

    @Schema(description = "Nome do cargo.", example = "Gerente", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank
    @Size(max = 80)
    private String nome;

    @Schema(description = "Descrição do cargo.", example = "Responsável pela gestão da pizzaria.")
    @Size(max = 255)
    private String descricao;

    @Schema(description = "Salário base do cargo.", example = "3500.00")
    @PositiveOrZero
    private BigDecimal salarioBase;

}