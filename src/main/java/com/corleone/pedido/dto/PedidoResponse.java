package com.corleone.pedido.dto;

import com.corleone.shared.enums.StatusPedido;
import com.corleone.shared.enums.TipoPedido;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO de resposta detalhada do pedido.")
public class PedidoResponse {

    @Schema(example = "1")
    private Integer id;

    @Schema(example = "1")
    private Integer clienteId;

    @Schema(example = "João da Silva")
    private String cliente;

    @Schema(example = "5")
    private Integer funcionarioId;

    @Schema(example = "Carlos")
    private String funcionario;

    @Schema(example = "3")
    private Integer mesaId;

    @Schema(example = "Mesa 03")
    private String mesa;

    @Schema(example = "2")
    private Integer cupomId;

    @Schema(example = "CUPOM10")
    private String cupom;

    @Schema(example = "1")
    private Integer pagamentoId;

    @Schema(example = "PIX")
    private String pagamento;

    private TipoPedido tipo;

    private BigDecimal subtotal;

    private BigDecimal desconto;

    private BigDecimal taxaEntrega;

    private BigDecimal total;

    private StatusPedido status;

    private String observacao;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    private List<ItemPedidoResponse> itens;
}