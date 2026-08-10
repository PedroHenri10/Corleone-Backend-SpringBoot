package com.corleone.cupom.dto;

import com.corleone.shared.enums.TipoCupom;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO de retorno completo do cupom.")
public class CupomResponse {

    @Schema(description = "ID do cupom.", example = "1")
    private Integer id;

    @Schema(description = "Código do cupom.", example = "PIZZA10")
    private String codigo;

    @Schema(description = "Descrição do cupom.", example = "Desconto de 10% em pedidos acima de R$ 50.")
    private String descricao;

    @Schema(description = "Tipo do desconto.", example = "PERCENTUAL")
    private TipoCupom tipo;

    @Schema(description = "Valor do desconto.", example = "10.00")
    private BigDecimal valor;

    @Schema(description = "Valor mínimo do pedido.", example = "50.00")
    private BigDecimal valorMinimo;

    @Schema(description = "Início da validade.", example = "2026-08-10T00:00:00")
    private LocalDateTime dataInicio;

    @Schema(description = "Fim da validade.", example = "2026-08-31T23:59:59")
    private LocalDateTime dataFim;

    @Schema(description = "Limite de utilizações.", example = "100")
    private Integer limiteUso;

    @Schema(description = "Indica se o cupom está ativo.", example = "true")
    private Boolean ativo;

    @Schema(description = "Data de criação do cupom.", example = "2026-08-10T10:00:00")
    private LocalDateTime dataCriacao;
}