package com.corleone.pedido.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Filtros utilizados para consulta do histórico de pedidos.")
public class HistoricoPedidoFilter {

    @Schema(description = "ID do pedido.", example = "1")
    private Integer pedidoId;

    @Schema(description = "ID do funcionário.", example = "5")
    private Integer funcionarioId;

    @Schema(description = "Status anterior.", example = "ABERTO")
    private String statusAnterior;

    @Schema(description = "Status novo.", example = "EM_PREPARO")
    private String statusNovo;

    @Schema(description = "Data inicial da pesquisa.", example = "2026-09-01")
    private LocalDate dataInicial;

    @Schema(description = "Data final da pesquisa.", example = "2026-09-30")
    private LocalDate dataFinal;
}