package com.corleone.categoria;

import com.corleone.cliente.dto.ClienteFiltro;
import com.corleone.cliente.dto.ClienteRequest;
import com.corleone.cliente.dto.ClienteResponse;
import com.corleone.cliente.dto.ClienteResumoResponse;
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

@Tag(name = "Cliente", description = "Gerenciamento de clientes da Corleone.")
public interface ClienteApi {

    @Operation(summary = "Cadastrar cliente", description = "Realiza o cadastro de um novo cliente.")
    @ApiResponse(responseCode = "201", description = "Cliente cadastrado com sucesso.", content = @Content(
                    schema = @Schema(implementation = ClienteResponse.class)))
    @ApiResponse(responseCode = "400", description = "Dados inválidos.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "409", description = "Já existe um cliente com esse e-mail.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "403", description = "Sem permissão.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<ClienteResponse> criar(@Parameter(description = "Dados do cliente") ClienteRequest request);

    @Operation(summary = "Buscar cliente por ID", description = "Retorna um cliente pelo identificador.")
    @ApiResponse(responseCode = "200", description = "Cliente encontrado.", content = @Content(
                    schema = @Schema(implementation = ClienteResponse.class)))
    @ApiResponse(responseCode = "404", description = "Cliente não encontrado.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "403", description = "Sem permissão.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<ClienteResponse> buscarPorId(@Parameter(description = "ID do cliente", example = "1") Integer id);

    @Operation(summary = "Listar clientes", description = "Lista os clientes utilizando filtros opcionais.")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso.", content = @Content(
                    array = @ArraySchema(schema = @Schema(implementation = ClienteResumoResponse.class))))
    @ApiResponse(responseCode = "403", description = "Sem permissão.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<Page<ClienteResumoResponse>> listar(ClienteFiltro filtro, Pageable pageable);

    @Operation(summary = "Atualizar cliente", description = "Atualiza os dados de um cliente.")
    @ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso.", content = @Content(
                    schema = @Schema(implementation = ClienteResponse.class)))
    @ApiResponse(responseCode = "400", description = "Dados inválidos.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "404", description = "Cliente não encontrado.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "409", description = "Já existe um cliente com esse e-mail.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "403", description = "Sem permissão.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<ClienteResponse> atualizar(@Parameter(description = "ID do cliente", example = "1") Integer id,
            @Parameter(description = "Dados do cliente") ClienteRequest request);

    @Operation(summary = "Desativar cliente", description = "Realiza a exclusão lógica do cliente.")
    @ApiResponse(responseCode = "204", description = "Cliente desativado com sucesso.")
    @ApiResponse(responseCode = "400", description = "O cliente informado já está inativo.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "404", description = "Cliente não encontrado.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "403", description = "Sem permissão.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<Void> desativar(@Parameter(description = "ID do cliente", example = "1") Integer id);
}