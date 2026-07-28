package com.corleone.estoque.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstoqueIngredienteResponse {

    private Integer ingredienteId;

    private String ingrediente;

    private BigDecimal quantidade;

    private LocalDateTime dataAtualizacao;
}