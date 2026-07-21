package com.corleone.fornecedor.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados para cadastro e atualização de fornecedor.")
public class FornecedorRequest {

    @NotBlank
    @Schema(description = "Razão social.", example = "Distribuidora Alimentos LTDA")
    private String nome;

    @Schema(description = "Nome fantasia.", example = "Distribuidora Corleone")
    private String nomeFantasia;

    @NotBlank
    @Schema(description = "CNPJ.", example = "12.345.678/0001-90")
    private String cnpj;

    @NotBlank
    @Schema(description = "Telefone.", example = "(19)99999-9999")
    private String telefone;

    @Email
    @NotBlank
    @Schema(description = "E-mail.", example = "contato@empresa.com")
    private String email;

    @Schema(description = "Nome do responsável.", example = "João Nagato")
    private String contatoResponsavel;

    @NotNull
    @Schema(description = "Identificador do endereço.", example = "1")
    private Integer enderecoId;
}