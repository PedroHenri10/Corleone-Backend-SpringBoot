package com.corleone.fornecedor.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Resumo dos dados do fornecedor otimizado para listagens paginadas.")
public class FornecedorResumoResponse {

    @Schema(description = "Identificador único do fornecedor.", example = "42")
    private Integer id;

    @Schema(description = "Razão social da empresa fornecedora.", example = "Distribuidora de Alimentos Alfa LTDA")
    private String nome;

    @Schema(description = "Número do CNPJ do fornecedor formatado.", example = "12.345.678/0001-90")
    private String cnpj;

    @Schema(description = "Número de telefone comercial com DDD.", example = "(11) 4002-8922")
    private String telefone;

    @Schema(description = "Status atual do fornecedor no sistema.", example = "true")
    private Boolean ativo;
}
