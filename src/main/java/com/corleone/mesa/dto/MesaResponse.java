package com.corleone.mesa.dto;

import com.corleone.shared.enums.StatusMesa;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO para retorno de dados da mesa")
public class MesaResponse {

    @Schema(description = "Identificador da mesa", example = "1")
    private Integer id;

    @Schema(description ="Número da mesa", example = "10")
    private Integer numero;

    @Schema(description ="Capacidade total da mesa", example = "4")
    private Integer capacidade;

    @Schema(description ="Status da mesa", example = "Livre")
    private StatusMesa status;

    @Schema(description ="mesa ativa", example = "ativo")
    private Boolean ativo;

    @Schema(description ="Data de criação da mesa", example = "10/10/2055")
    private LocalDateTime dataCriacao;
}
