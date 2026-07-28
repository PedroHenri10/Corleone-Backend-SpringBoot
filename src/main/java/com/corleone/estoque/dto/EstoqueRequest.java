package com.corleone.estoque.dto;

import com.corleone.shared.enums.TipoMovimentacao;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Dados para movimentação de estoque.")
public class EstoqueRequest {

    @NotNull
    @Schema(description = "Produto.", example = "1")
    private Integer produtoId;

    @NotNull
    @Schema(description = "Funcionário responsável.", example = "2")
    private Integer funcionarioId;

    @NotNull
    @Schema(description = "Tipo da movimentação.")
    private TipoMovimentacao tipo;

    @NotNull
    @DecimalMin("0.001")
    @Schema(description = "Quantidade.", example = "20")
    private BigDecimal quantidade;

    @NotNull
    @DecimalMin("0.00")
    @Schema(description = "Valor unitário.", example = "15.50")
    private BigDecimal valorUnitario;

    @Size(max = 100)
    @Schema(description = "Documento.", example = "NF-12345")
    private String documento;

    @Size(max = 255)
    @Schema(description = "Observação.")
    private String observacao;
}