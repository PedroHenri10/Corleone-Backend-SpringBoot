package com.corleone.estoque.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstoqueAtualResponse {

    private Integer produtoId;

    private String produto;

    private BigDecimal quantidade;

    private LocalDateTime dataAtualizacao;
}