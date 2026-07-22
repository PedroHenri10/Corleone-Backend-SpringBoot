package com.corleone.sabor.dto;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaborFiltro {

    @Parameter(description = "Busca parcial pelo nome.", example = "Calab")
    private String nome;

    @Parameter(description = "Filtrar ativos.", example = "true")
    private Boolean ativo;
}