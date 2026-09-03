package com.corleone.caixa.dto;

import com.corleone.shared.enums.TipoLancamentoCaixa;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Filtros utilizados para consulta de lançamentos de caixa.")
public class LancamentoCaixaFilter {
}
