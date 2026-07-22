package com.corleone.usuario.docs;

import com.corleone.usuario.dto.UsuarioRequest;
import com.corleone.usuario.dto.UsuarioResponse;
import com.corleone.usuario.dto.UsuarioResumoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Usuários", description = "Gerenciamento de usuários do sistema.")
public interface UsuarioApi {

    @Operation(summary = "Cadastrar usuário", description = "Cria um novo usuário associado a um funcionário.")
    @ApiResponse(responseCode = "201", description = "Usuário criado.", content = @Content(
            schema = @Schema(implementation = UsuarioResponse.class)))
    @ApiResponse(responseCode = "400", description = "Dados inválidos.", content = @Content)
    @ApiResponse(responseCode = "401", description = "Não autenticado.", content = @Content)
    @ApiResponse(responseCode = "403", description = "Sem permissão.", content = @Content)
    ResponseEntity<UsuarioResponse> criar(@Valid @RequestBody UsuarioRequest request);

    @Operation(summary = "Atualizar usuário", description = "Atualiza os dados do usuário.")
    @ApiResponse(responseCode = "200", description = "Usuário atualizado.")
    @ApiResponse(responseCode = "400", description = "Dados inválidos.", content = @Content)
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado.", content = @Content)
    ResponseEntity<UsuarioResponse> atualizar(@Parameter(description = "Id do usuário") Integer id, @Valid
            @RequestBody UsuarioRequest request);

    @Operation(summary = "Buscar usuário", description = "Busca um usuário pelo identificador.")
    @ApiResponse(responseCode = "200", description = "Usuário encontrado.", content = @Content(
            schema = @Schema(implementation = UsuarioResponse.class)))
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado.", content = @Content)
    ResponseEntity<UsuarioResponse> buscarPorId(@Parameter(description = "Id do usuário") Integer id);

    @Operation(summary = "Listar usuários", description = "Lista todos os usuários paginados.")
    @ApiResponse(responseCode = "200", description = "Lista retornada.", content = @Content(
            array = @ArraySchema(
                    schema = @Schema(implementation = UsuarioResumoResponse.class))))
    ResponseEntity<Page<UsuarioResumoResponse>> listar(Pageable pageable);

    @Operation(summary = "Desativar usuário", description = "Realiza exclusão lógica do usuário.")
    @ApiResponse(responseCode = "204", description = "Usuário desativado.")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado.", content = @Content)
    @ApiResponse(responseCode = "422", description = "Usuário já inativo.")
    ResponseEntity<Void> desativar(@Parameter(description = "Id do usuário") Integer id);

}