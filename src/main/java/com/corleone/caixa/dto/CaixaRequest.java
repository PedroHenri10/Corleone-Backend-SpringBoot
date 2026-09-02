package com.corleone.caixa.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO utilizado para abertura e atualização dos dados do caixa.")
public class CaixaRequest {

    @NotNull
    @Schema(description = "ID do funcionário responsável pelo caixa.", example = "10")
    private Integer funcionarioId;

    @NotNull
    @DecimalMin(value = "0.00")
    @Digits(integer = 8, fraction = 2)
    @Schema(description = "Valor informado na abertura do caixa.", example = "150.00")
    private BigDecimal valorAbertura;

    @Size(max = 255)
    @Schema(description = "Observação relacionada à abertura ou operação do caixa.", example = "Caixa aberto para o turno da noite.")
    private String observacao;
}