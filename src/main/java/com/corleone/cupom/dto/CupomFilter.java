package com.corleone.cupom.dto;

import com.corleone.shared.enums.TipoCupom;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Filtros utilizados para consulta de cupons.")
public class CupomFilter {

    @Schema(description = "Código do cupom.", example = "PIZZA10")
    private String codigo;

    @Schema(description = "Tipo do cupom.", example = "PERCENTUAL")
    private TipoCupom tipo;

    @Schema(description = "Indica se o cupom está ativo.", example = "true")
    private Boolean ativo;

    @Schema(description = "Data inicial para pesquisa.", example = "2026-08-01")
    private LocalDate dataInicio;

    @Schema(description = "Data final para pesquisa.", example = "2026-08-31")
    private LocalDate dataFim;
}