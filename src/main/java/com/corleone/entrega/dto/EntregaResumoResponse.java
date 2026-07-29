package com.corleone.entrega.dto;

import com.corleone.shared.enums.StatusEntrega;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Resumo da entrega.")
public class EntregaResumoResponse {

    private Integer id;

    private Integer pedidoId;

    private String entregador;

    private StatusEntrega status;

    private Integer previsaoMinutos;

}
