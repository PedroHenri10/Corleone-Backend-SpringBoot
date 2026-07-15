package com.corleone.auth.docs;

import com.corleone.auth.dto.LoginRequest;
import com.corleone.auth.dto.LoginResponse;
import com.corleone.shared.dto.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Autenticação", description = "Endpoints para gerenciamento de acesso e login")
public interface AuthApi {

    @Operation(
            summary = "Realizar login do usuário",
            description = "Valida as credenciais enviadas e retorna os dados de autenticação."
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "Login realizado com sucesso",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "401",
                    description = "Credenciais inválidas ou não autorizadas",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))
            )
    })
    ResponseEntity<ApiResponse<LoginResponse>> login(@RequestBody LoginRequest request);
}