package com.corleone.cliente.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados detalhados do cliente para retorno nas APIs.")
public class ClienteResponse {

    @Schema(description = "Identificador único do cliente.", example = "1")
    private Integer id;

    @Schema(description = "Nome completo do cliente.", example = "João da Silva")
    private String nome;

    @Schema(description = "Telefone celular principal.", example = "(19) 99999-9999")
    private String telefone1;

    @Schema(description = "Telefone fixo ou secundário.", example = "(19) 3333-3333")
    private String telefone2;

    @Schema(description = "Endereço de e-mail do cliente.", example = "joao@email.com")
    private String email;

    @Schema(description = "Status atual do cadastro.", example = "ATIVO")
    private String status;

    @Schema(description = "Indicador se o cliente está ativo no sistema.", example = "true")
    private Boolean ativo;

    @Schema(description = "Identificador do endereço associado.", example = "12")
    private Integer enderecoId;

    @Schema(description = "Nome da cidade do cliente.", example = "Campinas")
    private String cidade;

    @Schema(description = "Sigla do estado (UF).", example = "SP")
    private String estado;

    @Schema(description = "Data e hora em que o cliente foi cadastrado.", example = "2026-10-23T12:00:00")
    private LocalDateTime dataCriacao;

    @Schema(description = "Data e hora da última atualização dos dados.", example = "2026-10-23T12:46:00")
    private LocalDateTime dataAtualizacao;

}
