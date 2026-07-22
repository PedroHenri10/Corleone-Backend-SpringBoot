package com.corleone.sabor.docs;

import com.corleone.sabor.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

@Tag(name = "Sabor", description = "Gerenciamento de sabores da Corleone.")
public interface SaborApi {

    @Operation(summary = "Cadastrar sabor", description = "Realiza o cadastro de um novo sabor.")
    @ApiResponse(responseCode = "201", description = "Sabor cadastrado com sucesso.", content = @Content(schema = @Schema(implementation = SaborResponse.class)))
    @ApiResponse(responseCode = "400", description = "Dados inválidos ou nome já cadastrado.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "403", description = "Sem permissão.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<SaborResponse> criar(@Parameter(description = "Dados do sabor") SaborRequest request);

    @Operation(summary = "Buscar sabor por ID", description = "Retorna um sabor pelo identificador.")
    @ApiResponse(responseCode = "200", description = "Sabor encontrado.", content = @Content(schema = @Schema(implementation = SaborResponse.class)))
    @ApiResponse(responseCode = "404", description = "Sabor não encontrado.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<SaborResponse> buscarPorId(@Parameter(description = "ID do sabor", example = "1") Integer id);

    @Operation(summary = "Listar sabores", description = "Lista os sabores cadastrados.")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso.", content = @Content(
                    schema = @Schema(implementation = Page.class)))
    ResponseEntity<Page<SaborResumoResponse>> listar(SaborFiltro filtro, Pageable pageable);

    @Operation(summary = "Atualizar sabor", description = "Atualiza os dados de um sabor.")
    @ApiResponse(responseCode = "200", description = "Sabor atualizado com sucesso.", content = @Content(schema = @Schema(implementation = SaborResponse.class)))
    @ApiResponse(responseCode = "400", description = "Dados inválidos ou nome já cadastrado.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "404", description = "Sabor não encontrado.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "403", description = "Sem permissão.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<SaborResponse> atualizar(@Parameter(description = "ID do sabor", example = "1") Integer id, @Parameter(description = "Dados do sabor") SaborRequest request);

    @Operation(summary = "Desativar sabor", description = "Realiza a exclusão lógica do sabor.")
    @ApiResponse(responseCode = "204", description = "Sabor desativado com sucesso.")
    @ApiResponse(responseCode = "400", description = "O sabor informado já está inativo.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "404", description = "Sabor não encontrado.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "403", description = "Sem permissão.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<Void> desativar(@Parameter(description = "ID do sabor", example = "1") Integer id);
}