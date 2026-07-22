package com.corleone.cargo.docs;

import com.corleone.cargo.dto.CargoRequest;
import com.corleone.cargo.dto.CargoResponse;
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

@Tag(name = "Cargo", description = "Gerenciamento de cargos dos funcionários.")
public interface CargoApi {

    @Operation(summary = "Cadastrar cargo", description = "Realiza o cadastro de um novo cargo.")
    @ApiResponse(responseCode = "201", description = "Cargo cadastrado com sucesso.", content = @Content(
            schema = @Schema(implementation = CargoResponse.class)))
    @ApiResponse(responseCode = "400", description = "Dados inválidos.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "409", description = "Já existe um cargo com esse nome.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "403", description = "Sem permissão.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<CargoResponse> criar(CargoRequest request);

    @Operation(summary = "Buscar cargo por ID", description = "Retorna um cargo pelo identificador.")
    @ApiResponse(responseCode = "200", description = "Cargo encontrado.", content = @Content(
            schema = @Schema(implementation = CargoResponse.class)))
    @ApiResponse(responseCode = "404", description = "Cargo não encontrado.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<CargoResponse> buscarPorId(@Parameter(description = "ID do cargo", example = "1") Integer id);

    @Operation(summary = "Listar cargos", description = "Lista todos os cargos cadastrados.")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso.", content = @Content(
            array = @ArraySchema(
                    schema = @Schema(implementation = CargoResponse.class))))
    ResponseEntity<List<CargoResponse>> listar();

    @Operation(summary = "Atualizar cargo", description = "Atualiza os dados de um cargo.")
    @ApiResponse(responseCode = "200", description = "Cargo atualizado.")
    @ApiResponse(responseCode = "400", description = "Dados inválidos.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "404", description = "Cargo não encontrado.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "409", description = "Nome já utilizado.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<CargoResponse> atualizar(@Parameter(description = "ID do cargo", example = "1") Integer id, CargoRequest request);

    @Operation(summary = "Desativar cargo", description = "Realiza a exclusão lógica do cargo.")
    @ApiResponse(responseCode = "204", description = "Cargo desativado.")
    @ApiResponse(responseCode = "404", description = "Cargo não encontrado.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "422", description = "Cargo já inativo.", content = @Content(schema = @Schema(hidden = true)))

    ResponseEntity<Void> desativar(@Parameter(description = "ID do cargo", example = "1") Integer id);
}