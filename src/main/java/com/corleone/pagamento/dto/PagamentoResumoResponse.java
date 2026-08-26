package com.corleone.pagamento.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Resumo da forma de pagamento.")
public class PagamentoResumoResponse {

    @Schema(description = "ID da forma de pagamento.", example = "1")
    private Integer id;

    @Schema(description = "Nome da forma de pagamento.", example = "Pix")
    private String nome;

    @Schema(description = "Indica se a forma de pagamento está ativa.", example = "true")
    private Boolean ativo;
}