package com.corleone.mesa.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "DTO utilizado para cadastro e atualizaçao de mesas")
public class MesaRequest {

    @Positive
    @NotNull
    @Schema(description ="Número da mesa", example = "10")
    private Integer numero;

    @Positive
    @Schema(description ="Capacidade total da mesa", example = "4")
    private Integer capacidade;
}
