package com.corleone.pedido.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO de resposta detalhada do item do pedido.")
public class ItemPedidoResponse {

    @Schema(example = "1")
    private Integer id;

    @Schema(example = "10")
    private Integer pedidoId;

    @Schema(example = "5")
    private Integer produtoId;

    @Schema(example = "Pizza Calabresa")
    private String produto;

    private BigDecimal quantidade;

    private BigDecimal precoUnitario;

    private BigDecimal desconto;

    private BigDecimal subtotal;

    private String observacao;
}