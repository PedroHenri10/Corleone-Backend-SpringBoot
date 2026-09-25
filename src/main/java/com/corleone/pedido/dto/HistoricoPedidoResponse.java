package com.corleone.pedido.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO de resposta do histórico do pedido.")
public class HistoricoPedidoResponse {

    @Schema(example = "1")
    private Integer id;

    @Schema(example = "10")
    private Integer pedidoId;

    @Schema(example = "5")
    private Integer funcionarioId;

    @Schema(example = "Carlos")
    private String funcionario;

    @Schema(example = "ABERTO")
    private String statusAnterior;

    @Schema(example = "EM_PREPARO")
    private String statusNovo;

    @Schema(example = "Pedido enviado para a cozinha.")
    private String observacao;

    private LocalDateTime data;
}