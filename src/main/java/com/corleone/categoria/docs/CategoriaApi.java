package com.corleone.categoria.docs;

import com.corleone.categoria.dto.CategoriaRequest;
import com.corleone.categoria.dto.CategoriaResponse;
import com.corleone.categoria.dto.CategoriaResumoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Categoria", description = "Gerenciamento de categorias da Corleone.")
public interface CategoriaApi {

    @Operation(summary = "Cadastrar categoria", description = "Realiza o cadastro de uma nova categoria.")
    @ApiResponse(responseCode = "201", description = "Categoria cadastrada com sucesso.", content = @Content(
                    schema = @Schema(implementation = CategoriaResponse.class)))
    @ApiResponse(responseCode = "400", description = "Dados inválidos.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "409", description = "Já existe uma categoria com esse nome.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "403", description = "Sem permissão.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<CategoriaResponse> criar(@Parameter(description = "Dados da categoria") CategoriaRequest request);

    @Operation(summary = "Buscar categoria por ID", description = "Retorna uma categoria pelo identificador.")
    @ApiResponse(responseCode = "200", description = "Categoria encontrada.", content = @Content(
                    schema = @Schema(implementation = CategoriaResponse.class)))
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<CategoriaResponse> buscarPorId(@Parameter(description = "ID da categoria", example = "1") Integer id);

    @Operation(summary = "Listar categorias", description = "Lista todas as categorias cadastradas.")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso.", content = @Content(
            array = @ArraySchema(
                            schema = @Schema(implementation = CategoriaResumoResponse.class))))
    ResponseEntity<List<CategoriaResumoResponse>> listar();

    @Operation(summary = "Atualizar categoria", description = "Atualiza os dados de uma categoria.")
    @ApiResponse(responseCode = "200", description = "Categoria atualizada com sucesso.", content = @Content(
                    schema = @Schema(implementation = CategoriaResponse.class)))
    @ApiResponse(responseCode = "400", description = "Dados inválidos.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "409", description = "Nome já utilizado.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<CategoriaResponse> atualizar(@Parameter(description = "ID da categoria", example = "1") Integer id, @Parameter(description = "Dados da categoria") CategoriaRequest request);

    @Operation(summary = "Desativar categoria", description = "Realiza a exclusão lógica da categoria.")
    @ApiResponse(responseCode = "204", description = "Categoria desativada com sucesso.")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "422", description = "Categoria já está inativa.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<Void> desativar(@Parameter(description = "ID da categoria", example = "1") Integer id);
}