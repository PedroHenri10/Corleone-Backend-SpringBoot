package com.corleone.promocao.dto;

import com.corleone.shared.enums.TipoPromocao;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO de retorno completo da promoção.")
public class PromocaoResponse {

    @Schema(description = "ID da promoção.", example = "1")
    private Integer id;

    @Schema(description = "Nome da promoção.", example = "Pizza do Dia")
    private String nome;

    @Schema(description = "Descrição da promoção.", example = "Pizza grande com desconto especial.")
    private String descricao;

    @Schema(description = "Tipo da promoção.", example = "DESCONTO_PERCENTUAL")
    private TipoPromocao tipo;

    @Schema(description = "Valor ou percentual aplicado.", example = "20.00")
    private BigDecimal valor;

    @Schema(description = "Valor mínimo para aplicação.", example = "50.00")
    private BigDecimal valorMinimo;

    @Schema(description = "Data de início.", example = "2026-08-20T18:00:00")
    private LocalDateTime dataInicio;

    @Schema(description = "Data de término.", example = "2026-08-20T23:30:00")
    private LocalDateTime dataFim;

    @Schema(description = "Indica se a promoção está ativa.", example = "true")
    private Boolean ativo;

    @Schema(description = "Data de criação.", example = "2026-08-19T09:00:00")
    private LocalDateTime dataCriacao;

    @Schema(description = "Data da última atualização.", example = "2026-08-19T10:00:00")
    private LocalDateTime dataAtualizacao;
}