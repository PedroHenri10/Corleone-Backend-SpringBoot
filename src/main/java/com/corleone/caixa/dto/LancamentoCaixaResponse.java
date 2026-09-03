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
@Schema(description = "DTO de retorno completo de um lançamento de caixa.")
public class LancamentoCaixaResponse {

    @Schema(description = "ID do lançamento.", example = "1")
    private Integer id;

    @Schema(description = "ID do caixa.", example = "1")
    private Integer caixaId;

    @Schema(description = "ID do funcionário responsável.", example = "10")
    private Integer funcionarioId;

    @Schema(description = "Nome do funcionário responsável.", example = "Pedro Henrique")
    private String funcionario;

    @Schema(description = "ID do pedido relacionado.", example = "25")
    private Integer pedidoId;

    @Schema(description = "ID da forma de pagamento relacionada.", example = "2")
    private Integer pagamentoId;

    @Schema(description = "Nome da forma de pagamento.", example = "Dinheiro")
    private String pagamento;

    @Schema(description = "Tipo do lançamento.", example = "SANGRIA")
    private TipoLancamentoCaixa tipo;

    @Schema(description = "Valor do lançamento.", example = "50.00")
    private BigDecimal valor;

    @Schema(description = "Descrição do lançamento.", example = "Sangria realizada durante o turno.")
    private String descricao;

    @Schema(description = "Data e hora do lançamento.", example = "2026-09-02T20:15:00")
    private LocalDateTime data;
}