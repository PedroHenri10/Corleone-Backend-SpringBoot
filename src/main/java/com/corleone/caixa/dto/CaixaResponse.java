package com.corleone.caixa.dto;

import com.corleone.shared.enums.StatusCaixa;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO de retorno completo do caixa.")
public class CaixaResponse {
}
