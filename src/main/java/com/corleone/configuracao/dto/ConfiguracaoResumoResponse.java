package com.corleone.configuracao.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO resumido utilizado na listagem de configurações.")
public class ConfiguracaoResumoResponse {

    @Schema(description = "ID da configuração.", example = "1")
    private Integer id;

    @Schema(description = "Chave da configuração.", example = "TAXA_ENTREGA")
    private String chave;

    @Schema(description = "Valor da configuração.", example = "5.00")
    private String valor;

    @Schema(description = "Descrição da configuração.", example = "Valor padrão da taxa de entrega.")
    private String descricao;
}
