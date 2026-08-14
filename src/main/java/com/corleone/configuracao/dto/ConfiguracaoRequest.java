package com.corleone.configuracao.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO utilizado para cadastro e atualização de configurações.")
public class ConfiguracaoRequest {

    @NotBlank
    @Size(max = 80)
    @Schema(description = "Chave única da configuração.", example = "TAXA_ENTREGA")
    private String chave;

    @NotBlank
    @Size(max = 255)
    @Schema(description = "Valor da configuração.", example = "5.00")
    private String valor;

    @Size(max = 255)
    @Schema(description = "Descrição da configuração.", example = "Valor padrão da taxa de entrega.")
    private String descricao;
}