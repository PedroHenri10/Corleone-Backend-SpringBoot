package com.corleone.endereco.docs;

import com.corleone.categoria.dto.CategoriaResponse;
import com.corleone.categoria.dto.CategoriaResumoResponse;
import com.corleone.endereco.dto.EnderecoRequest;
import com.corleone.endereco.dto.EnderecoResponse;
import com.corleone.endereco.dto.EnderecoResumoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EnderecoApi {

    @Operation(summary = "Cadastrar endereço", description = "Realiza o cadastro de um novo endereço.")
    @ApiResponse(responseCode = "201", description = "Endereço cadastrado com sucesso.", content = @Content(
            schema = @Schema(implementation = EnderecoResponse.class)))
    @ApiResponse(responseCode = "400", description = "Dados inválidos.", content = @Content)
    ResponseEntity<EnderecoResponse> criar(@Valid @RequestBody EnderecoRequest request);

    @Operation(summary = "Buscar endereço por ID", description = "Retorna um endereço pelo identificador.")
    @ApiResponse(responseCode = "200", description = "Endereço encontrado.",content = @Content(
            schema = @Schema(implementation = EnderecoResponse.class)))
    @ApiResponse(responseCode = "404", description = "Endereço não encontrado.", content = @Content)
    ResponseEntity<EnderecoResponse> buscarPorId(@PathVariable Integer id);

    @Operation(summary = "Listar endereços", description = "Retorna todos os endereços cadastrados.")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso.", content = @Content(
            array = @ArraySchema(
                    schema = @Schema(implementation = EnderecoResumoResponse.class))))
    ResponseEntity<List<EnderecoResumoResponse>> listar();

    @Operation(summary = "Atualizar endereço", description = "Atualiza os dados de um endereço.")
    @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso.")
    @ApiResponse(responseCode = "400", description = "Dados inválidos.", content = @Content)
    @ApiResponse(responseCode = "404", description = "Endereço não encontrado.", content = @Content)
    ResponseEntity<EnderecoResponse> atualizar(@PathVariable Integer id, @Valid @RequestBody EnderecoRequest request);

    @Operation(summary = "Excluir endereço", description = "Remove um endereço do sistema.")
    @ApiResponse(responseCode = "204", description = "Endereço excluído com sucesso.")
    @ApiResponse(responseCode = "404", description = "Endereço não encontrado.", content = @Content)
    ResponseEntity<Void> excluir(@PathVariable Integer id);
}