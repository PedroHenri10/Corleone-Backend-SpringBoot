package com.corleone.pedido.dto;

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
@Schema(description = "DTO utilizado para cadastro e atualização de itens do pedido.")
public class ItemPedidoRequest {

    @NotNull
    @Schema(description = "ID do produto.", example = "10")
    private Integer produtoId;

    @NotNull
    @DecimalMin(value = "0.001")
    @Schema(description = "Quantidade do produto.", example = "2")
    private BigDecimal quantidade;

    @Size(max = 255)
    @Schema(description = "Observação do item.", example = "Sem cebola.")
    private String observacao;
}