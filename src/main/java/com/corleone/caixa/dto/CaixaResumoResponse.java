package com.corleone.caixa.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO resumido utilizado na listagem de caixas.")
public class CaixaResumoResponse {
}
