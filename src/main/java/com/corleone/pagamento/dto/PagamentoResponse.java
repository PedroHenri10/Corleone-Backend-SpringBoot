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
}
