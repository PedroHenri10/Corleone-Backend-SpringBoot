package com.corleone.caixa.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO utilizado para abertura e atualização dos dados do caixa.")
public class CaixaRequest {
}
