package com.corleone.entrega.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados para criação de uma entrega.")
public class EntregaRequest {

    @NotNull
    @Schema(description = "ID do pedido.", example = "15")
    private Integer pedidoId;

    @NotNull
    @Schema(description = "ID do entregador.", example = "3")
    private Integer entregadorId;

    @NotNull
    @Schema(description = "ID do endereço de entrega.", example = "12")
    private Integer enderecoId;

    @NotNull
    @PositiveOrZero
    @Schema(description = "Taxa de entrega.", example = "8.50")
    private BigDecimal taxa;

    @NotNull
    @PositiveOrZero
    @Schema(description = "Distância em quilômetros.", example = "6.40")
    private BigDecimal distancia;

    @NotNull
    @Positive
    @Schema(description = "Previsão em minutos.", example = "45")
    private Integer previsaoMinutos;

    @Size(max = 255)
    @Schema(description = "Observações da entrega.", example = "Entregar na portaria.")
    private String observacao;

}