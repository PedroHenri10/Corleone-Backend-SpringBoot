package com.corleone.caixa.dto;

import com.corleone.shared.enums.StatusCaixa;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO resumido utilizado na listagem de caixas.")
public class CaixaResumoResponse {

    @Schema(description = "ID do caixa.", example = "1")
    private Integer id;

    @Schema(description = "Funcionário responsável.", example = "Pedro Henrique")
    private String funcionario;

    @Schema(description = "Data de abertura.", example = "2026-09-02T18:00:00")
    private LocalDateTime dataAbertura;

    @Schema(description = "Data de fechamento.", example = "2026-09-02T23:30:00")
    private LocalDateTime dataFechamento;

    @Schema(description = "Valor de abertura.", example = "150.00")
    private BigDecimal valorAbertura;

    @Schema(description = "Valor de fechamento.", example = "1280.00")
    private BigDecimal valorFechamento;

    @Schema(description = "Status atual do caixa.", example = "FECHADO")
    private StatusCaixa status;
}