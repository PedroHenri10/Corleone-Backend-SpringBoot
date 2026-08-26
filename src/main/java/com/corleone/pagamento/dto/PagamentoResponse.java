package com.corleone.pagamento.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados completos da forma de pagamento.")
public class PagamentoResponse {

    @Schema(description = "ID da forma de pagamento.", example = "1")
    private Integer id;

    @Schema(description = "Nome da forma de pagamento.", example = "Cartão de Crédito")
    private String nome;

    @Schema(description = "Indica se a forma de pagamento requer troco.", example = "false")
    private Boolean requerTroco;

    @Schema(description = "Indica se a forma de pagamento está ativa.", example = "true")
    private Boolean ativo;
}