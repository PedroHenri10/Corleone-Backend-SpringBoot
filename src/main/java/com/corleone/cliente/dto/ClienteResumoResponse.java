package com.corleone.cliente.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Resumo dos dados do cliente otimizado para listagens.")
public class ClienteResumoResponse {

    @Schema(description = "Identificador único do cliente.", example = "1")
    private Integer id;

    @Schema(description = "Nome completo do cliente.", example = "João da Silva")
    private String nome;

    @Schema(description = "Telefone principal do cliente.", example = "(19) 99999-9999")
    private String telefone1;

    @Schema(description = "Endereço de e-mail do cliente.", example = "joao@email.com")
    private String email;

    @Schema(description = "Nome da cidade do cliente.", example = "Campinas")
    private String cidade;

    @Schema(description = "Indicador se o cliente está ativo no sistema.", example = "true")
    private Boolean ativo;

}
