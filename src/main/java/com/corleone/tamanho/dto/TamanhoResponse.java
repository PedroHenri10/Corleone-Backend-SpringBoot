package com.corleone.tamanho.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados de um tamanho.")
public class TamanhoResponse {

    private Integer id;

    private String nome;

    private BigDecimal fatorPreco;

}