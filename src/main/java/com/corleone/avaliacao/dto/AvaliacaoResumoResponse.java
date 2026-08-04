package com.corleone.avaliacao.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO resumido utilizado nas listagens de avaliações.")
public class AvaliacaoResumoResponse {

    @Schema(description = "ID da avaliação.", example = "1")
    private Integer id;

    @Schema(description = "Cliente que realizou a avaliação.", example = "João Silva")
    private String cliente;

    @Schema(description = "Nota atribuída.", example = "5")
    private Integer nota;

    @Schema(description = "Comentário.", example = "Muito bom.")
    private String comentario;

    @Schema(description = "Data da avaliação.", example = "2026-08-04T20:30:00")
    private LocalDateTime dataCriacao;

}
