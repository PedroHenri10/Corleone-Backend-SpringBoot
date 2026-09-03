package com.corleone.caixa.dto;

import com.corleone.shared.enums.TipoLancamentoCaixa;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO utilizado para cadastro de lançamentos no caixa.")
public class LancamentoCaixaRequest {

    @NotNull
    @Schema(description = "ID do caixa.", example = "1")
    private Integer caixaId;

    @NotNull
    @Schema(description = "ID do funcionário responsável pelo lançamento.", example = "10")
    private Integer funcionarioId;

    @Schema(description = "ID do pedido relacionado ao lançamento. Opcional.", example = "25")
    private Integer pedidoId;

    @Schema(description = "ID da forma de pagamento relacionada ao lançamento. Opcional.", example = "2")
    private Integer pagamentoId;

    @NotNull
    @Schema(description = "Tipo do lançamento.", example = "SANGRIA")
    private TipoLancamentoCaixa tipo;

    @NotNull
    @DecimalMin(value = "0.01")
    @Digits(integer = 8, fraction = 2)
    @Schema(description = "Valor do lançamento.", example = "50.00")
    private BigDecimal valor;

    @Size(max = 255)
    @Schema(description = "Descrição do lançamento.", example = "Sangria realizada durante o turno.")
    private String descricao;
}