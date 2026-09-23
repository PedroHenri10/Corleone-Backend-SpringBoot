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
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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

    @Operation(
            summary = "Obter dados do usuário logado",
            description = "Recupera as informações do usuário autenticado."
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "Usuário autenticado",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = ApiResponse.class,
                                    subTypes = {MeResponse.class}
                            )
                    )
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Usuário não autenticado")
    })
    ResponseEntity<ApiResponse<MeResponse>> me(@AuthenticationPrincipal UserDetails user);
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
