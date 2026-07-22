package com.corleone.borda.dto;

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
@Schema(description = "Dados para cadastro e atualização da borda.")
public class BordaRequest {

    @NotBlank
    @Size(max = 80)
    @Schema(description = "Nome da borda.", example = "Catupiry")
    private String nome;

    @NotNull
    @DecimalMin("0.00")
    @Schema(description = "Preço da borda.", example = "8.50")
    private BigDecimal preco;

}