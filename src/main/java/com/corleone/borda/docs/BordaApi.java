package com.corleone.borda.docs;

import com.corleone.borda.dto.BordaRequest;
import com.corleone.borda.dto.BordaResponse;
import com.corleone.borda.dto.BordaResumoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Borda", description = "Gerenciamento das bordas da Corleone.")
public interface BordaApi {

    @Operation(summary = "Cadastrar borda", description = "Realiza o cadastro de uma nova borda.")
    @ApiResponse(responseCode = "201", description = "Borda cadastrada com sucesso.", content = @Content(schema = @Schema(implementation = BordaResponse.class)))
    @ApiResponse(responseCode = "400", description = "Dados inválidos.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "409", description = "Já existe uma borda com esse nome.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "403", description = "Sem permissão.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<BordaResponse> criar(@Parameter(description = "Dados da borda") BordaRequest request);

    @Operation(summary = "Buscar borda por ID", description = "Retorna uma borda pelo identificador.")
    @ApiResponse(responseCode = "200", description = "Borda encontrada.", content = @Content(schema = @Schema(implementation = BordaResponse.class)))
    @ApiResponse(responseCode = "404", description = "Borda não encontrada.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<BordaResponse> buscarPorId(@Parameter(description = "ID da borda", example = "1") Integer id);

    @Operation(summary = "Listar bordas", description = "Lista todas as bordas cadastradas.")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso.", content = @Content(
                    array = @ArraySchema(
                            schema = @Schema(implementation = BordaResumoResponse.class))))
    ResponseEntity<List<BordaResumoResponse>> listar();

    @Operation(summary = "Atualizar borda", description = "Atualiza os dados de uma borda.")
    @ApiResponse(responseCode = "200", description = "Borda atualizada com sucesso.", content = @Content(schema = @Schema(implementation = BordaResponse.class)))
    @ApiResponse(responseCode = "400", description = "Dados inválidos.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "404", description = "Borda não encontrada.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "409", description = "Já existe uma borda com esse nome.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<BordaResponse> atualizar(@Parameter(description = "ID da borda", example = "1") Integer id,
                                            @Parameter(description = "Dados da borda") BordaRequest request);

    @Operation(summary = "Desativar borda", description = "Realiza a exclusão lógica da borda.")
    @ApiResponse(responseCode = "204", description = "Borda desativada com sucesso.")
    @ApiResponse(responseCode = "400", description = "A borda já está inativa.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "404", description = "Borda não encontrada.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<Void> desativar(@Parameter(description = "ID da borda", example = "1") Integer id);
}
