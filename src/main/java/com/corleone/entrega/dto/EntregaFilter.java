package com.corleone.entrega.dto;


import com.corleone.shared.enums.StatusEntrega;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Filtros para pesquisa de entregas.")
public class EntregaFilter {

    private Integer pedidoId;

    private Integer entregadorId;

    private StatusEntrega status;

}
