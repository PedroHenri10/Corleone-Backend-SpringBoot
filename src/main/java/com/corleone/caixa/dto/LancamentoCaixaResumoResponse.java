package com.corleone.caixa.dto;

import com.corleone.shared.enums.TipoLancamentoCaixa;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO resumido utilizado na listagem de lançamentos de caixa.")
public class LancamentoCaixaResumoResponse {

    @Schema(description = "ID do lançamento.", example = "1")
    private Integer id;

    @Schema(description = "ID do caixa.", example = "1")
    private Integer caixaId;

    @Schema(description = "Funcionário responsável.", example = "Pedro Henrique")
    private String funcionario;

    @Schema(description = "Tipo do lançamento.", example = "SUPRIMENTO")
    private TipoLancamentoCaixa tipo;

    @Schema(description = "Valor do lançamento.", example = "100.00")
    private BigDecimal valor;

    @Schema(description = "Descrição do lançamento.", example = "Reforço de troco.")
    private String descricao;

    @Schema(description = "Data e hora do lançamento.", example = "2026-09-02T19:30:00")
    private LocalDateTime data;
}