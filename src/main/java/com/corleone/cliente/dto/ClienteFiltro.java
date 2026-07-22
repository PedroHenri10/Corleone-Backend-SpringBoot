package com.corleone.cliente.dto;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteFiltro {

    @Parameter(description = "Busca parcial pelo nome.")
    private String nome;

    @Parameter(description = "Busca parcial pelo telefone.")
    private String telefone;

    @Parameter(description = "Busca exata pelo e-mail.")
    private String email;

    @Parameter(description = "Busca pelo status.")
    private String status;

    @Parameter(description = "Cidade.")
    private String cidade;

    @Parameter(description = "Cliente ativo.")
    private Boolean ativo;

}