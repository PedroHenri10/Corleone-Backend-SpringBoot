package com.corleone.caixa.dto;

import com.corleone.shared.enums.TipoLancamentoCaixa;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO de retorno completo de um lançamento de caixa.")
public class LancamentoCaixaResponse {
}
