package com.corleone.cliente.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados completos do cliente.")
public class ClienteResponse {

    private Integer id;

    private String nome;

    private String telefone1;

    private String telefone2;

    private String email;

    private String status;

    private Boolean ativo;

    private Integer enderecoId;

    private String cidade;

    private String estado;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

}