package com.corleone.pagamento.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO utilizado para cadastro e atualização de formas de pagamento.")
public class PagamentoRequest {
    
}
