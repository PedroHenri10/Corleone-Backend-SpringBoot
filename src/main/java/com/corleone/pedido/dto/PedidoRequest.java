package com.corleone.pedido.dto;

import com.corleone.shared.enums.TipoPedido;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO utilizado para cadastro e atualização de pedidos.")
public class PedidoRequest {

    @Schema(description = "ID do cliente.", example = "1")
    private Integer clienteId;

    @NotNull
    @Schema(description = "ID do funcionário responsável pelo pedido.", example = "5")
    private Integer funcionarioId;

    @Schema(description = "ID da mesa.", example = "3")
    private Integer mesaId;

    @Schema(description = "ID do cupom aplicado.", example = "2")
    private Integer cupomId;

    @Schema(description = "ID da forma de pagamento.", example = "1")
    private Integer pagamentoId;

    @NotNull
    @Schema(description = "Tipo do pedido.", example = "ENTREGA")
    private TipoPedido tipo;

    @Size(max = 255)
    @Schema(description = "Observação do pedido.", example = "Entregar sem cebola.")
    private String observacao;

    @Schema(description = "Itens que compõem o pedido.")
    private List<ItemPedidoRequest> itens;
}