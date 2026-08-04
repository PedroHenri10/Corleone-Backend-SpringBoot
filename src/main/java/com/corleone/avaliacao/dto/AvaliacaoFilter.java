package com.corleone.avaliacao.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Filtros utilizados para consulta de avaliações.")
public class AvaliacaoFilter {

    @Schema(description = "ID do cliente.", example = "5")
    private Integer clienteId;

    @Schema(description = "ID do pedido.", example = "10")
    private Integer pedidoId;

    @Schema(description = "Nota atribuída.", example = "5")
    private Integer nota;

    @Schema(description = "Data inicial da pesquisa.", example = "2026-08-01")
    private LocalDate dataInicial;

    @Schema(description = "Data final da pesquisa.", example = "2026-08-31")
    private LocalDate dataFinal;

}