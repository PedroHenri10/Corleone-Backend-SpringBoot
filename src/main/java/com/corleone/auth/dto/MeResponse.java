package com.corleone.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Schema(description = "Estrutura com os dados essenciais do perfil do usuário logado atualmente")
public class MeResponse {

    @Schema(description = "Identificador único do usuário no banco de dados", example = "42")
    private Integer id;

    @Schema(description = "Nome de usuário ou login utilizado no sistema", example = "admin")
    private String login;
}

