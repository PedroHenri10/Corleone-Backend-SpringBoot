package com.corleone.auth.docs;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Dados necessários para autenticação no sistema")
public class LoginRequest {

    @Schema(description = "Nome de usuário ou e-mail cadastrado", example = "admin", requiredMode = Schema.RequiredMode.REQUIRED)
    private String username;

    @Schema(description = "Senha de acesso do usuário", example = "123456", requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;
}
