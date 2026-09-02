package com.corleone.caixa.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Filtros utilizados para consulta de caixas.")
public class CaixaFilter {
}
