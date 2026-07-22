package com.corleone.tamanho.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Resumo de tamanho.")
public class TamanhoResumoResponse {

    private Integer id;

    private String nome;

    private BigDecimal fatorPreco;

}