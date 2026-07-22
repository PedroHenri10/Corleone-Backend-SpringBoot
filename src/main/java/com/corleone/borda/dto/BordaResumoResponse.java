package com.corleone.borda.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Resumo da borda.")
public class BordaResumoResponse {

    private Integer id;

    private String nome;

    private BigDecimal preco;

    private Boolean ativo;

}