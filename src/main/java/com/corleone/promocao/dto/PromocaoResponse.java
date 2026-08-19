package com.corleone.promocao.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO de retorno completo da promoção.")
public class PromocaoResponse {

    @Schema(description = "ID da promoção.", example = "1")
    private Integer id;

    @Schema(description = "ID do produto.", example = "10")
    private Integer produtoId;

    @Schema(description = "Nome do produto.", example = "Pizza Calabresa")
    private String produto;

    @Schema(description = "Nome da promoção.", example = "Pizza do Dia")
    private String nome;

    @Schema(description = "Descrição da promoção.", example = "20% de desconto na pizza selecionada.")
    private String descricao;

    @Schema(description = "Percentual de desconto.", example = "20.00")
    private BigDecimal percentual;

    @Schema(description = "Data e hora de início.", example = "2026-08-20T18:00:00")
    private LocalDateTime dataInicio;

    @Schema(description = "Data e hora de término.", example = "2026-08-20T23:30:00")
    private LocalDateTime dataFim;

    @Schema(description = "Indica se a promoção está ativa.", example = "true")
    private Boolean ativa;
}