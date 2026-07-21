package com.corleone.fornecedor.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Parâmetros de paginação e busca para filtragem de fornecedores.")
public class FornecedorFiltro {

    @Schema(description = "Filtro para busca parcial pelo nome ou razão social.", example = "Alfa")
    private String nome;

    @Schema(description = "Filtro para busca exata pelo número do CNPJ (pode conter pontuação).", example = "12.345.678/0001-90")
    private String cnpj;

    @Schema(description = "Filtro para busca exata ou parcial pelo nome da cidade.", example = "Campinas")
    private String cidade;

    @Schema(description = "Filtro para listar apenas registros ativos (true) ou inativos (false).", example = "true")
    private Boolean ativo;
}
