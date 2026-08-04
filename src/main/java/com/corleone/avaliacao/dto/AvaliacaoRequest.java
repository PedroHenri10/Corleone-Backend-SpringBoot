package com.corleone.avaliacao.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO utilizado para cadastro de uma avaliação.")
public class AvaliacaoRequest {

    @NotNull
    @Schema(description = "ID do pedido avaliado.", example = "10")
    private Integer pedidoId;

    @NotNull
    @Schema(description = "ID do cliente que realizou a avaliação.", example = "5")
    private Integer clienteId;

    @NotNull
    @Min(1)
    @Max(5)
    @Schema(description = "Nota atribuída ao pedido.", example = "5")
    private Integer nota;

    @Schema(description = "Comentário realizado pelo cliente.", example = "Pizza excelente, entrega muito rápida.")
    private String comentario;

}