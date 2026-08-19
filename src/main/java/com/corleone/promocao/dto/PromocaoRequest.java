package com.corleone.promocao.dto;

import com.corleone.shared.enums.TipoPromocao;
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

    @NotBlank
    @Size(max = 100)
    @Schema(description = "Nome da promoção.", example = "Pizza do Dia")
    private String nome;

    @Size(max = 255)
    @Schema(description = "Descrição da promoção.", example = "Pizza grande com desconto especial.")
    private String descricao;

    @NotNull
    @Schema(description = "Tipo da promoção.", example = "DESCONTO_PERCENTUAL")
    private TipoPromocao tipo;

    @NotNull
    @DecimalMin(value = "0.01")
    @Schema(description = "Valor ou percentual aplicado pela promoção.", example = "20.00")
    private BigDecimal valor;

    @DecimalMin(value = "0.00")
    @Schema(description = "Valor mínimo necessário para aplicação da promoção.", example = "50.00")
    private BigDecimal valorMinimo;

    @NotNull
    @Schema(description = "Data e hora de início da promoção.", example = "2026-08-20T18:00:00")
    private LocalDateTime dataInicio;

    @NotNull
    @Schema(description = "Data e hora de término da promoção.", example = "2026-08-20T23:30:00")
    private LocalDateTime dataFim;

    @Schema(description = "Indica se a promoção está ativa.", example = "true")
    private Boolean ativo;
}