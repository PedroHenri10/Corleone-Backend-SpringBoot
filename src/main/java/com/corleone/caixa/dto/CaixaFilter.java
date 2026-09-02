package com.corleone.caixa.dto;

import com.corleone.shared.enums.StatusCaixa;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Filtros utilizados para consulta de caixas.")
public class CaixaFilter {

    @Schema(description = "ID do funcionário responsável.", example = "10")
    private Integer funcionarioId;

    @Schema(description = "Status do caixa.", example = "ABERTO")
    private StatusCaixa status;

    @Schema(description = "Data inicial da pesquisa.", example = "2026-09-01")
    private LocalDate dataInicial;

    @Schema(description = "Data final da pesquisa.", example = "2026-09-30")
    private LocalDate dataFinal;
}