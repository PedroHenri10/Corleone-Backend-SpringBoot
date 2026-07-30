package com.corleone.mesa.dto;

import com.corleone.shared.enums.StatusMesa;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "DTO utilizado para filtros de pesquisa de mesas")
public class MesaFilter {

    @Schema(description = "Número da mesa", example = "10")
    private Integer numero;

    @Schema(description = "Capacidade da mesa", example = "4")
    private Integer capacidade;

    @Schema(description = "Status da mesa", example = "LIVRE")
    private StatusMesa status;

    @Schema(description = "Indica se a mesa está ativa", example = "true")
    private Boolean ativo;

}