package com.corleone.pedido.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO utilizado para associação de uma borda ao item do pedido.")
public class PedidoBordaRequest {

    @NotNull
    @Schema(description = "ID do item do pedido.", example = "10")
    private Integer itemPedidoId;

    @NotNull
    @Schema(description = "ID da borda.", example = "2")
    private Integer bordaId;
}