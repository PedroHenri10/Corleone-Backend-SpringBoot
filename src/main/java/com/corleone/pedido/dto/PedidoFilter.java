package com.corleone.pedido.dto;

import com.corleone.shared.enums.StatusPedido;
import com.corleone.shared.enums.TipoPedido;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Filtros utilizados para consulta de pedidos.")
public class PedidoFilter {

    @Schema(description = "ID do cliente.", example = "1")
    private Integer clienteId;

    @Schema(description = "ID do funcionário.", example = "5")
    private Integer funcionarioId;

    @Schema(description = "ID da mesa.", example = "3")
    private Integer mesaId;

    @Schema(description = "Tipo do pedido.", example = "ENTREGA")
    private TipoPedido tipo;

    @Schema(description = "Status do pedido.", example = "EM_PREPARO")
    private StatusPedido status;

    @Schema(description = "Data inicial da pesquisa.", example = "2026-09-01")
    private LocalDate dataInicial;

    @Schema(description = "Data final da pesquisa.", example = "2026-09-30")
    private LocalDate dataFinal;
}