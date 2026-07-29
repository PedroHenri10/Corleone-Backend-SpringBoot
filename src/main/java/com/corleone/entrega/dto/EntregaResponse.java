package com.corleone.entrega.dto;

import com.corleone.shared.enums.StatusEntrega;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados completos da entrega.")
public class EntregaResponse {

    private Integer id;

    private Integer pedidoId;

    private Integer entregadorId;

    private String entregador;

    private Integer enderecoId;

    private BigDecimal taxa;

    private BigDecimal distancia;

    private Integer previsaoMinutos;

    private LocalDateTime dataSaida;

    private LocalDateTime dataEntrega;

    private StatusEntrega status;

    private String observacao;

}
