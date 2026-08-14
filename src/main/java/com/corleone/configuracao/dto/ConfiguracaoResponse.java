package com.corleone.configuracao.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO de retorno completo da configuração.")
public class ConfiguracaoResponse {

    @Schema(description = "ID da configuração.", example = "1")
    private Integer id;

    @Schema(description = "Chave única da configuração.", example = "TAXA_ENTREGA")
    private String chave;

    @Schema(description = "Valor da configuração.", example = "5.00")
    private String valor;

    @Schema(description = "Descrição da configuração.", example = "Valor padrão da taxa de entrega.")
    private String descricao;

    @Schema(description = "Data de criação da configuração.", example = "2026-08-14T10:00:00")
    private LocalDateTime dataCriacao;

    @Schema(description = "Data da última atualização da configuração.", example = "2026-08-14T10:30:00")
    private LocalDateTime dataAtualizacao;
}