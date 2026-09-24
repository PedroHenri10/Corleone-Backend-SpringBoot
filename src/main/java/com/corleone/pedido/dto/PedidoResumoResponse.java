package com.corleone.pedido.dto;

import com.corleone.shared.enums.StatusPedido;
import com.corleone.shared.enums.TipoPedido;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO resumido do pedido.")
public class PedidoResumoResponse {

    @Schema(example = "1")
    private Integer id;

    @Schema(example = "João da Silva")
    private String cliente;

    @Schema(example = "Carlos")
    private String funcionario;

    private TipoPedido tipo;

    private BigDecimal total;

    private StatusPedido status;

    private LocalDateTime dataCriacao;
}