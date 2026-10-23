package com.corleone.cliente.dto;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Objeto de filtros para consulta de clientes")
public class ClienteFiltro {

    @Parameter(description = "Busca parcial pelo nome.", example = "Don Vitor", required = false)
    private String nome;

    @Parameter(description = "Busca parcial pelo telefone.", example = "(11) 98765-4321", required = false)
    private String telefone;

    @Parameter(description = "Busca exata pelo e-mail.", example = "vitor@corleone.com", required = false)
    private String email;

    @Parameter(description = "Busca pelo status.", example = "PREMIUM", required = false)
    private String status;

    @Parameter(description = "Cidade.", example = "Belo Horizonte", required = false)
    private String cidade;

    @Parameter(description = "Cliente ativo.", example = "true", required = false)
    private Boolean ativo;

}