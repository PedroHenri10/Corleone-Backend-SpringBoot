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
public class EstoqueResumoResponse {

    private Integer id;

    private String produto;

    private TipoMovimentacao tipo;

    private BigDecimal quantidade;

    private LocalDateTime dataMovimentacao;
}