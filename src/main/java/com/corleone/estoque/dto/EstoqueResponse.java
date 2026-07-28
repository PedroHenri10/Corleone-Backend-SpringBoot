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
public class EstoqueResponse {

    private Integer id;

    private Integer produtoId;

    private String produto;

    private Integer funcionarioId;

    private String funcionario;

    private TipoMovimentacao tipo;

    private BigDecimal quantidade;

    private BigDecimal valorUnitario;

    private String documento;

    private String observacao;

    private LocalDateTime dataMovimentacao;
}