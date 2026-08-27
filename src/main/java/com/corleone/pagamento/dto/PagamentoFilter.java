package com.corleone.pagamento.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Filtros utilizados para consulta de formas de pagamento.")
public class PagamentoFilter {

    @Schema(description = "Nome ou parte do nome da forma de pagamento.", example = "Cartão")
    private String nome;

    @Schema(description = "Filtra pelo status da forma de pagamento.", example = "true")
    private Boolean ativo;
}