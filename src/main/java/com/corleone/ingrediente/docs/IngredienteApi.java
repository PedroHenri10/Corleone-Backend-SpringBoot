package com.corleone.ingrediente.docs;

import com.corleone.ingrediente.dto.IngredienteFilter;
import com.corleone.ingrediente.dto.IngredienteRequest;
import com.corleone.ingrediente.dto.IngredienteResponse;
import com.corleone.ingrediente.dto.IngredienteResumoResponse;
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

@Tag(name = "Ingrediente", description = "Gerenciamento de ingredientes da Corleone.")
public interface IngredienteApi {

    @Operation(summary = "Cadastrar ingrediente", description = "Realiza o cadastro de um novo ingrediente.")
    @ApiResponse(responseCode = "201", description = "Ingrediente cadastrado com sucesso.",
            content = @Content(
                    schema = @Schema(implementation = IngredienteResponse.class)
            )
    )
    @ApiResponse(responseCode = "400", description = "Dados inválidos.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "403", description = "Sem permissão.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "409", description = "Já existe um ingrediente com esse nome.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<IngredienteResponse> criar(@Parameter(description = "Dados do ingrediente") IngredienteRequest request);

    @Operation(summary = "Buscar ingrediente por ID", description = "Retorna um ingrediente pelo identificador.")
    @ApiResponse(responseCode = "200", description = "Ingrediente encontrado.",
            content = @Content(
                    schema = @Schema(implementation = IngredienteResponse.class)
            )
    )
    @ApiResponse(responseCode = "404", description = "Ingrediente não encontrado.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<IngredienteResponse> buscarPorId(@Parameter(description = "ID do ingrediente", example = "1") Integer id);

    @Operation(summary = "Listar ingredientes", description = "Lista os ingredientes cadastrados utilizando filtros.")
    @ApiResponse(responseCode = "200", description = "Ingredientes listados com sucesso.", content = @Content(
                    array = @ArraySchema(
                            schema = @Schema(implementation = IngredienteResumoResponse.class)
                    )
            )
    )
    ResponseEntity<Page<IngredienteResumoResponse>> listar(IngredienteFilter filtro, Pageable pageable);

    @Operation(summary = "Atualizar ingrediente", description = "Atualiza os dados de um ingrediente.")
    @ApiResponse(responseCode = "200", description = "Ingrediente atualizado com sucesso.",
            content = @Content(
                    schema = @Schema(implementation = IngredienteResponse.class)
            )
    )
    @ApiResponse(responseCode = "400", description = "Dados inválidos.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "404", description = "Ingrediente não encontrado.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "409", description = "Já existe um ingrediente com esse nome.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<IngredienteResponse> atualizar(@Parameter(description = "ID do ingrediente", example = "1") Integer id,
            @Parameter(description = "Dados do ingrediente") IngredienteRequest request);

    @Operation(summary = "Desativar ingrediente", description = "Realiza a exclusão lógica do ingrediente.")
    @ApiResponse(responseCode = "204", description = "Ingrediente desativado com sucesso.")
    @ApiResponse(responseCode = "404", description = "Ingrediente não encontrado.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "422", description = "Ingrediente já está inativo.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<Void> desativar(@Parameter(description = "ID do ingrediente", example = "1") Integer id);
}