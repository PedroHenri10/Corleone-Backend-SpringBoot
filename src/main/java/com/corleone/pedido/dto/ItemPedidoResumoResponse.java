package com.corleone.pedido.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO resumido do item do pedido.")
public class ItemPedidoResumoResponse {

    @Schema(example = "1")
    private Integer id;

    @Schema(example = "Pizza Calabresa")
    private String produto;

    private BigDecimal quantidade;

    private BigDecimal subtotal;
}