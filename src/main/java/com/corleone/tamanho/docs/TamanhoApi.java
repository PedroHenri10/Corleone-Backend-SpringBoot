package com.corleone.tamanho.docs;

import com.corleone.tamanho.dto.TamanhoRequest;
import com.corleone.tamanho.dto.TamanhoResponse;
import com.corleone.tamanho.dto.TamanhoResumoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Tamanho", description = "Gerenciamento dos tamanhos das pizzas.")
public interface TamanhoApi {

    @Operation(summary = "Cadastrar tamanho", description = "Realiza o cadastro de um novo tamanho.")
    @ApiResponse(responseCode = "201", description = "Tamanho cadastrado com sucesso.", content = @Content(
                    schema = @Schema(implementation = TamanhoResponse.class)))
    @ApiResponse(responseCode = "400", description = "Dados inválidos.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "409", description = "Já existe um tamanho com esse nome.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<TamanhoResponse> criar(TamanhoRequest request);

    @Operation(summary = "Buscar tamanho por ID", description = "Retorna um tamanho pelo identificador.")
    @ApiResponse(responseCode = "200", description = "Tamanho encontrado.", content = @Content(
                    schema = @Schema(implementation = TamanhoResponse.class)))
    @ApiResponse(responseCode = "404", description = "Tamanho não encontrado.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<TamanhoResponse> buscarPorId(Integer id);

    @Operation(summary = "Listar tamanhos", description = "Lista todos os tamanhos cadastrados.")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso.", content = @Content(
                    array = @ArraySchema(
                            schema = @Schema(implementation = TamanhoResumoResponse.class))))
    ResponseEntity<List<TamanhoResumoResponse>> listar();

    @Operation(summary = "Atualizar tamanho", description = "Atualiza os dados de um tamanho.")
    @ApiResponse(responseCode = "200", description = "Tamanho atualizado com sucesso.", content = @Content(
                    schema = @Schema(implementation = TamanhoResponse.class)))
    @ApiResponse(responseCode = "400", description = "Dados inválidos.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "404", description = "Tamanho não encontrado.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "409", description = "Já existe um tamanho com esse nome.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<TamanhoResponse> atualizar(Integer id, TamanhoRequest request);

    @Operation(summary = "Excluir tamanho", description = "Remove um tamanho.")
    @ApiResponse(responseCode = "204", description = "Tamanho removido com sucesso.")
    @ApiResponse(responseCode = "404", description = "Tamanho não encontrado.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "422", description = "Tamanho informado já está inativo.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<Void> desativar(Integer id);
}