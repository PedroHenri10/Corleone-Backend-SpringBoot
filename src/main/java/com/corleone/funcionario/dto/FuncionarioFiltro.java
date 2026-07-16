package com.corleone.funcionario.dto;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioFiltro {

    @Parameter(description = "Busca parcial pelo nome.", example = "Andre")
    private String nome;

    @Parameter(description = "Busca exata pelo CPF.", example = "123.456.789-00")
    private String cpf;

    @Parameter(description = "Identificador do cargo.", example = "2")
    private Integer cargoId;

    @Parameter(description = "Filtra funcionários ativos ou inativos.", example = "true")
    private Boolean ativo;

    @Parameter(description = "Busca parcial pela cidade.", example = "Campinas")
    private String cidade;

    @Parameter(description = "Data inicial de admissão.", example = "2025-01-01")
    private LocalDate dataAdmissaoInicio;

    @Parameter(description = "Data final de admissão.", example = "2025-12-31")
    private LocalDate dataAdmissaoFim;

}