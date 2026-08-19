package com.corleone.promocao.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO utilizado para cadastro e atualização de promoções.")
public class PromocaoRequest {

    @NotNull
    @Schema(description = "ID do produto que receberá a promoção.", example = "10")
    private Integer produtoId;

    @NotBlank
    @Size(max = 120)
    @Schema(description = "Nome da promoção.", example = "Pizza do Dia")
    private String nome;

    @Size(max = 255)
    @Schema(description = "Descrição da promoção.", example = "20% de desconto na pizza selecionada.")
    private String descricao;

    @NotNull
    @DecimalMin(value = "0.01")
    @DecimalMax(value = "100.00")
    @Schema(description = "Percentual de desconto da promoção.", example = "20.00")
    private BigDecimal percentual;

    @NotNull
    @Schema(description = "Data e hora de início da promoção.", example = "2026-08-20T18:00:00")
    private LocalDateTime dataInicio;

    @NotNull
    @Schema(description = "Data e hora de término da promoção.", example = "2026-08-20T23:30:00")
    private LocalDateTime dataFim;

    @Schema(description = "Indica se a promoção está ativa.", example = "true")
    private Boolean ativa;
}