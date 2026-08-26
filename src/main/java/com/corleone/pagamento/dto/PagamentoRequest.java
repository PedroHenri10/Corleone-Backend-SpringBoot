package com.corleone.pagamento.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO utilizado para cadastro e atualização de formas de pagamento.")
public class PagamentoRequest {

    @NotBlank
    @Size(max = 60)
    @Schema(description = "Nome da forma de pagamento.", example = "Cartão de Crédito")
    private String nome;

    @NotNull
    @Schema(description = "Indica se a forma de pagamento permite ou exige troco.", example = "false")
    private Boolean requerTroco;
}