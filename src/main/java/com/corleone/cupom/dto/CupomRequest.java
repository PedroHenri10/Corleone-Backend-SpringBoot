package com.corleone.cupom.dto;

import com.corleone.shared.enums.TipoCupom;
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
@Schema(description = "DTO utilizado para cadastro e atualização de cupons.")
public class CupomRequest {

    @NotBlank
    @Size(max = 30)
    @Schema(description = "Código único do cupom.", example = "PIZZA10")
    private String codigo;

    @Size(max = 255)
    @Schema(description = "Descrição do cupom.", example = "Desconto de 10% em pedidos acima de R$ 50.")
    private String descricao;

    @NotNull
    @Schema(description = "Tipo do desconto aplicado pelo cupom.", example = "PERCENTUAL")
    private TipoCupom tipo;

    @NotNull
    @DecimalMin(value = "0.01")
    @Digits(integer = 8, fraction = 2)
    @Schema(description = "Valor do desconto.", example = "10.00")
    private BigDecimal valor;

    @DecimalMin(value = "0.01")
    @Digits(integer = 8, fraction = 2)
    @Schema(description = "Valor mínimo do pedido para utilização do cupom.", example = "50.00")
    private BigDecimal valorMinimo;

    @Schema(description = "Data e hora de início da validade do cupom.", example = "2026-08-10T00:00:00")
    private LocalDateTime dataInicio;

    @Schema(description = "Data e hora de término da validade do cupom.", example = "2026-08-31T23:59:59")
    private LocalDateTime dataFim;

    @Positive
    @Schema(description = "Quantidade máxima de utilizações do cupom.", example = "100")
    private Integer limiteUso;
}