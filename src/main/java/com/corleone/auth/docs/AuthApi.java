package com.corleone.auth.docs;

import com.corleone.auth.dto.LoginRequest;
import com.corleone.auth.dto.LoginResponse;
import com.corleone.auth.dto.MeResponse;
import com.corleone.auth.dto.RefreshTokenRequest;
import com.corleone.auth.dto.RefreshTokenResponse;
import com.corleone.shared.dto.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Autenticação", description = "Endpoints para gerenciamento de acesso, sessão e renovação de tokens")
public interface AuthApi {

    @Operation(
            summary = "Realizar login do usuário",
            description = "Valida as credenciais enviadas e retorna o token de acesso inicial."
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "Login realizado com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = ApiResponse.class,
                                    subTypes = {LoginResponse.class}
                            )
                    )
            )
    })
    ResponseEntity<ApiResponse<LoginResponse>> login(@RequestBody LoginRequest request);

    @Operation(summary = "Obter dados do usuário logado", description = "Recupera as informações essenciais do perfil do usuário através do token ativo.")
    @ApiResponses(value = {@io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "Dados do perfil retornados com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = MeResponse.class))
            )
    })
    ResponseEntity<MeResponse> me(@org.springframework.security.core.annotation.AuthenticationPrincipal org.springframework.security.core.userdetails.UserDetails user);

    @Operation(
            summary = "Renovar token de acesso (Refresh)",
            description = "Recebe um token e gera uma nova credencial de acesso com tempo de expiração renovado."
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "Token renovado com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = ApiResponse.class,
                                    subTypes = {RefreshTokenResponse.class}
                            )
                    )
            )
    })
    ResponseEntity<ApiResponse<RefreshTokenResponse>> refresh(@RequestBody RefreshTokenRequest request);
}
