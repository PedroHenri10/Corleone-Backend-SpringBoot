package com.corleone.cupom.dto;

import com.corleone.shared.enums.TipoCupom;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO resumido utilizado na listagem de cupons.")
public class CupomResumoResponse {

    @Schema(description = "ID do cupom.", example = "1")
    private Integer id;

    @Schema(description = "Código do cupom.", example = "PIZZA10")
    private String codigo;

    @Schema(description = "Tipo do desconto.", example = "PERCENTUAL")
    private TipoCupom tipo;

    @Schema(description = "Valor do desconto.", example = "10.00")
    private BigDecimal valor;

    @Schema(description = "Data de início da validade.", example = "2026-08-10T00:00:00")
    private LocalDateTime dataInicio;

    @Schema(description = "Data de término da validade.", example = "2026-08-31T23:59:59")
    private LocalDateTime dataFim;

    @Schema(description = "Indica se o cupom está ativo.", example = "true")
    private Boolean ativo;
}