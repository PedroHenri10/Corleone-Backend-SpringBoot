package com.corleone.fornecedor.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados detalhados do fornecedor.")
public class FornecedorResponse {

    @Schema(description = "Identificador único do fornecedor no sistema.", example = "42")
    private Integer id;

    @Schema(description = "Razão social da empresa fornecedora.", example = "Distribuidora de Alimentos Alfa LTDA")
    private String nome;

    @Schema(description = "Nome fantasia utilizado comercialmente pela empresa.", example = "Alfa Suprimentos")
    private String nomeFantasia;

    @Schema(description = "Número do CNPJ do fornecedor formatado.", example = "12.345.678/0001-90")
    private String cnpj;

    @Schema(description = "Número de telefone comercial com DDD.", example = "(11) 4002-8922")
    private String telefone;

    @Schema(description = "E-mail principal para contato corporativo.", example = "comercial@alfasuprimentos.com")
    private String email;

    @Schema(description = "Nome da pessoa ou departamento responsável pelo atendimento.", example = "Roberto Silva")
    private String contatoResponsavel;

    @Schema(description = "Indicador se o cadastro do fornecedor está ativo para operações.", example = "true")
    private Boolean ativo;

    @Schema(description = "Identificador único do endereço vinculado a este fornecedor.", example = "105")
    private Integer enderecoId;

    @Schema(description = "Nome da cidade onde o fornecedor está localizado.", example = "São Paulo")
    private String cidade;

    @Schema(description = "Sigla do estado (UF) de localização do fornecedor.", example = "SP")
    private String estado;

    @Schema(description = "Data e hora em que o fornecedor foi cadastrado no sistema.", example = "2026-03-15T10:30:00")
    private LocalDateTime dataCriacao;

    @Schema(description = "Data e hora da última alteração nos dados do fornecedor.", example = "2026-07-21T14:15:22")
    private LocalDateTime dataAtualizacao;
}
