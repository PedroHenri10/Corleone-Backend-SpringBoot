package com.corleone.caixa.dto;

import com.corleone.shared.enums.TipoLancamentoCaixa;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Filtros utilizados para consulta de lançamentos de caixa.")
public class LancamentoCaixaFilter {

    @Schema(description = "ID do caixa.", example = "1")
    private Integer caixaId;

    @Schema(description = "ID do funcionário responsável.", example = "10")
    private Integer funcionarioId;

    @Schema(description = "ID do pedido relacionado.", example = "25")
    private Integer pedidoId;

    @Schema(description = "ID da forma de pagamento.", example = "2")
    private Integer pagamentoId;

    @Schema(description = "Tipo do lançamento.", example = "SANGRIA")
    private TipoLancamentoCaixa tipo;

    @Schema(description = "Data inicial da pesquisa.", example = "2026-09-01")
    private LocalDate dataInicial;

    @Schema(description = "Data final da pesquisa.", example = "2026-09-30")
    private LocalDate dataFinal;
}