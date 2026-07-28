package com.corleone.estoque.docs;

import com.corleone.estoque.dto.*;
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

@Tag(name = "Estoque", description = "Gerenciamento do estoque da Corleone.")
public interface EstoqueApi {

    @Operation(summary = "Registrar entrada de produto")
    @ApiResponse(responseCode = "201", description = "Entrada registrada.", content = @Content(schema = @Schema(implementation = EstoqueResponse.class)))
    ResponseEntity<EstoqueResponse> entrada(EstoqueRequest request);

    @Operation(summary = "Registrar saída de produto")
    @ApiResponse(responseCode = "201", description = "Saída registrada.", content = @Content(schema = @Schema(implementation = EstoqueResponse.class)))
    ResponseEntity<EstoqueResponse> saida(EstoqueRequest request);

    @Operation(summary = "Registrar ajuste de produto")
    @ApiResponse(responseCode = "201", description = "Ajuste registrado.", content = @Content(schema = @Schema(implementation = EstoqueResponse.class)))
    ResponseEntity<EstoqueResponse> ajuste(EstoqueRequest request);

    @Operation(summary = "Buscar movimentação")
    @ApiResponse(responseCode = "200", description = "Movimentação encontrada.", content = @Content(schema = @Schema(implementation = EstoqueResponse.class)))
    ResponseEntity<EstoqueResponse> buscarPorId(@Parameter(example = "1") Integer id);

    @Operation(summary = "Listar movimentações")
    @ApiResponse(responseCode = "200", description = "Lista retornada.", content = @Content(array = @ArraySchema(schema = @Schema(implementation = EstoqueResumoResponse.class))))
    ResponseEntity<Page<EstoqueResumoResponse>> listar(EstoqueFilter filter, Pageable pageable);

    @Operation(summary = "Listar estoque atual")
    @ApiResponse(responseCode = "200", description = "Estoque atual.", content = @Content(array = @ArraySchema(schema = @Schema(implementation = EstoqueAtualResponse.class))))
    ResponseEntity<Page<EstoqueAtualResponse>> listarEstoqueAtual(Pageable pageable);

    @Operation(summary = "Registrar entrada de ingrediente")
    @ApiResponse(responseCode = "201", description = "Entrada registrada.", content = @Content(schema = @Schema(implementation = MovimentoIngredienteResponse.class)))
    ResponseEntity<MovimentoIngredienteResponse> entradaIngrediente(MovimentoIngredienteRequest request);

    @Operation(summary = "Registrar saída de ingrediente")
    @ApiResponse(responseCode = "201", description = "Saída registrada.", content = @Content(schema = @Schema(implementation = MovimentoIngredienteResponse.class)))
    ResponseEntity<MovimentoIngredienteResponse> saidaIngrediente(MovimentoIngredienteRequest request);

    @Operation(summary = "Registrar ajuste de ingrediente")
    @ApiResponse(responseCode = "201", description = "Ajuste registrado.", content = @Content(schema = @Schema(implementation = MovimentoIngredienteResponse.class)))
    ResponseEntity<MovimentoIngredienteResponse> ajusteIngrediente(MovimentoIngredienteRequest request);

    @Operation(summary = "Buscar movimentação de ingrediente")
    @ApiResponse(responseCode = "200", description = "Movimentação encontrada.", content = @Content(schema = @Schema(implementation = MovimentoIngredienteResponse.class)))
    ResponseEntity<MovimentoIngredienteResponse> buscarMovimentoIngrediente(@Parameter(example = "1") Integer id);

    @Operation(summary = "Listar movimentações de ingredientes")
    @ApiResponse(responseCode = "200", description = "Lista retornada.", content = @Content(array = @ArraySchema(schema = @Schema(implementation = MovimentoIngredienteResumoResponse.class))))
    ResponseEntity<Page<MovimentoIngredienteResumoResponse>> listarMovimentosIngrediente(MovimentoIngredienteFilter filter, Pageable pageable);

    @Operation(summary = "Listar estoque de ingredientes")
    @ApiResponse(responseCode = "200", description = "Lista retornada.", content = @Content(array = @ArraySchema(schema = @Schema(implementation = EstoqueIngredienteResponse.class))))
    ResponseEntity<Page<EstoqueIngredienteResponse>> listarEstoqueIngrediente(Pageable pageable);
}