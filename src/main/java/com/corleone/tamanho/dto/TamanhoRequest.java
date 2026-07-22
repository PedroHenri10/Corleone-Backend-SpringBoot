package com.corleone.tamanho.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados para cadastro e atualização de tamanho.")
public class TamanhoRequest {

    @NotBlank
    @Size(max = 50)
    @Schema(description = "Nome do tamanho.", example = "Grande")
    private String nome;

    @NotNull
    @DecimalMin("0.01")
    @Schema(description = "Fator multiplicador do preço.", example = "1.50")
    private BigDecimal fatorPreco;

}