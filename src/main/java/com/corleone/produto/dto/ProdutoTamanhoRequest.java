package com.corleone.produto.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Tamanho disponível para o produto.")
public class ProdutoTamanhoRequest {

    @NotNull
    @Schema(example = "1")
    private Integer tamanhoId;

    @NotNull
    @DecimalMin("0.00")
    @Schema(example = "49.90")
    private BigDecimal preco;

}