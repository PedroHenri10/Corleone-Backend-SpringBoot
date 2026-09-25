package com.corleone.pedido.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO de resposta da borda associada ao item do pedido.")
public class PedidoBordaResponse {

    @Schema(example = "1")
    private Integer id;

    @Schema(example = "10")
    private Integer itemPedidoId;

    @Schema(example = "2")
    private Integer bordaId;

    @Schema(example = "Catupiry")
    private String borda;
}