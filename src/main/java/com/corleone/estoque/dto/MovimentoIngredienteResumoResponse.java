package com.corleone.estoque.dto;

import com.corleone.shared.enums.TipoMovimentacao;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovimentoIngredienteResumoResponse {

    private Integer id;

    private String ingrediente;

    private TipoMovimentacao tipo;

    private BigDecimal quantidade;

    private LocalDateTime dataMovimentacao;
}