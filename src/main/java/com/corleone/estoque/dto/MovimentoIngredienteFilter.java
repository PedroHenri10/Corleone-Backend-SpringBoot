package com.corleone.estoque.dto;

import com.corleone.shared.enums.TipoMovimentacao;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MovimentoIngredienteFilter {

    private Integer ingredienteId;

    private TipoMovimentacao tipo;

    private LocalDateTime dataInicial;

    private LocalDateTime dataFinal;
}