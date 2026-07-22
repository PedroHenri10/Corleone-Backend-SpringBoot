package com.corleone.cliente.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Resumo utilizado nas listagens.")
public class ClienteResumoResponse {

    private Integer id;

    private String nome;

    private String telefone1;

    private String email;

    private String cidade;

    private Boolean ativo;

}