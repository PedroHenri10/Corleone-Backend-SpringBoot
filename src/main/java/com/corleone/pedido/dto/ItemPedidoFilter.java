package com.corleone.pedido.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Filtros utilizados para consulta de itens de pedido.")
public class ItemPedidoFilter {

    @Schema(description = "ID do pedido.", example = "1")
    private Integer pedidoId;

    @Schema(description = "ID do produto.", example = "10")
    private Integer produtoId;
}