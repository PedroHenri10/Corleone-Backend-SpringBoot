package com.corleone.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Dados necessários para renovar o token de acesso expirado")
public class RefreshTokenRequest {

    @Schema(
            description = "O Refresh Token associado à sessão do usuário",
            example = "8f3b9c4d-2e1a-4b5c-8d7e-9f0a1b2c3d4e",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String token;
}
