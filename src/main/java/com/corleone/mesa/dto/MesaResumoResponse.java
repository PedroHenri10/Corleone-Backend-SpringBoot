package com.corleone.mesa.dto;

import com.corleone.shared.enums.StatusMesa;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "DTO utilizado para listagem resumida de mesas")
public class MesaResumoResponse {

    @Schema(description = "Identificador da mesa", example = "1")
    private Integer id;

    @Schema(description = "Número da mesa", example = "10")
    private Integer numero;

    @Schema(description = "Capacidade da mesa", example = "4")
    private Integer capacidade;

    @Schema(description = "Status atual da mesa", example = "LIVRE")
    private StatusMesa status;

}