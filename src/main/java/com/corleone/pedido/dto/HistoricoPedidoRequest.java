package com.corleone.pedido.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO utilizado para registrar uma observação no histórico do pedido.")
public class HistoricoPedidoRequest {

    @Schema(description = "ID do funcionário responsável pela alteração.", example = "5")
    private Integer funcionarioId;

    @Size(max = 255)
    @Schema(description = "Observação sobre a alteração do pedido.", example = "Pedido enviado para a cozinha.")
    private String observacao;
}