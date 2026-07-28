package com.corleone.estoque.dto;

import com.corleone.shared.enums.TipoMovimentacao;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovimentoIngredienteRequest {

    @NotNull
    private Integer ingredienteId;

    @NotNull
    private Integer funcionarioId;

    @NotNull
    private TipoMovimentacao tipo;

    @NotNull
    @DecimalMin("0.001")
    private BigDecimal quantidade;

    @NotNull
    @DecimalMin("0.00")
    private BigDecimal valorUnitario;

    @Size(max = 100)
    private String documento;

    @Size(max = 255)
    private String observacao;
}