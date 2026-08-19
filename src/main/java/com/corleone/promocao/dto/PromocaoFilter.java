package com.corleone.promocao.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Filtros utilizados para consulta de promoções.")
public class PromocaoFilter {

    @Schema(description = "ID do produto.", example = "10")
    private Integer produtoId;

    @Schema(description = "Nome da promoção.", example = "Pizza do Dia")
    private String nome;

    @Schema(description = "Indica se a promoção está ativa.", example = "true")
    private Boolean ativa;

    @Schema(description = "Data inicial do período de busca.", example = "2026-08-01T00:00:00")
    private LocalDateTime dataInicio;

    @Schema(description = "Data final do período de busca.", example = "2026-08-31T23:59:59")
    private LocalDateTime dataFim;
}