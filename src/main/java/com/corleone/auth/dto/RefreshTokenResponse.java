package com.corleone.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@Schema(description = "Resposta contendo o novo token de acesso gerado")
public class RefreshTokenResponse {

    @Schema(
            description = "O novo Token JWT de acesso gerado para autenticar as próximas requisições",
            example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
    )
    private String token;
}
