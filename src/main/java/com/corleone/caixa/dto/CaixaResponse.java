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
@Schema(description = "DTO de retorno completo do caixa.")
public class CaixaResponse {

    @Schema(description = "ID do caixa.", example = "1")
    private Integer id;

    @Schema(description = "ID do funcionário responsável.", example = "10")
    private Integer funcionarioId;

    @Schema(description = "Nome do funcionário responsável.", example = "Pedro Henrique")
    private String funcionario;

    @Schema(description = "Data e hora de abertura.", example = "2026-09-02T18:00:00")
    private LocalDateTime dataAbertura;

    @Schema(description = "Data e hora de fechamento.", example = "2026-09-02T23:30:00")
    private LocalDateTime dataFechamento;

    @Schema(description = "Valor informado na abertura.", example = "150.00")
    private BigDecimal valorAbertura;

    @Schema(description = "Valor informado no fechamento.", example = "1280.00")
    private BigDecimal valorFechamento;

    @Schema(description = "Valor calculado pelo sistema.", example = "1275.00")
    private BigDecimal valorSistema;

    @Schema(description = "Diferença entre valor informado e valor calculado.", example = "5.00")
    private BigDecimal diferenca;

    @Schema(description = "Status atual do caixa.", example = "ABERTO")
    private StatusCaixa status;

    @Schema(description = "Observação do caixa.", example = "Fechamento realizado normalmente.")
    private String observacao;
}