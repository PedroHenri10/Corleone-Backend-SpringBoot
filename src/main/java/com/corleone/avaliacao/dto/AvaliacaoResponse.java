package com.corleone.avaliacao.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO de retorno completo da avaliação.")
public class AvaliacaoResponse {

    @Schema(description = "ID da avaliação.", example = "1")
    private Integer id;

    @Schema(description = "ID do pedido.", example = "10")
    private Integer pedidoId;

    @Schema(description = "ID do cliente.", example = "5")
    private Integer clienteId;

    @Schema(description = "Nome do cliente.", example = "João Silva")
    private String cliente;

    @Schema(description = "Nota da avaliação.", example = "5")
    private Integer nota;

    @Schema(description = "Comentário informado pelo cliente.", example = "Pizza excelente.")
    private String comentario;

    @Schema(description = "Data da avaliação.", example = "2026-08-04T20:30:00")
    private LocalDateTime dataCriacao;

}