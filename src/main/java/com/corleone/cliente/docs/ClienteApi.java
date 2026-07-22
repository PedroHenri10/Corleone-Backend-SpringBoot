package com.corleone.cliente.docs;

import com.corleone.cliente.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Clientes", description = "Gerenciamento de clientes.")
public interface ClienteApi {

    @Operation(summary = "Cadastrar cliente")
    @ApiResponse(responseCode = "201", description = "Cliente cadastrado com sucesso.")
    @ApiResponse(responseCode = "400", description = "Dados inválidos ou e-mail já cadastrado.",
            content = @Content(schema = @Schema()))
    @ApiResponse(responseCode = "404", description = "Endereço não encontrado.",
            content = @Content(schema = @Schema()))
    @ApiResponse(responseCode = "403", description = "Acesso negado.")
    @PostMapping
    ResponseEntity<ClienteResponse> criar(
            @Valid @RequestBody ClienteRequest request
    );

    @Operation(summary = "Buscar cliente por ID")
    @ApiResponse(responseCode = "200", description = "Cliente encontrado.")
    @ApiResponse(responseCode = "404", description = "Cliente não encontrado.",
            content = @Content(schema = @Schema()))
    @ApiResponse(responseCode = "403", description = "Acesso negado.")
    @GetMapping("/{id}")
    ResponseEntity<ClienteResponse> buscarPorId(
            @PathVariable Integer id
    );

    @Operation(summary = "Listar clientes")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso.")
    @ApiResponse(responseCode = "403", description = "Acesso negado.")
    @GetMapping
    ResponseEntity<Page<ClienteResumoResponse>> listar(
            ClienteFiltro filtro,
            Pageable pageable
    );

    @Operation(summary = "Atualizar cliente")
    @ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso.")
    @ApiResponse(responseCode = "400", description = "Dados inválidos ou e-mail já cadastrado.",
            content = @Content(schema = @Schema()))
    @ApiResponse(responseCode = "404", description = "Cliente ou endereço não encontrado.",
            content = @Content(schema = @Schema()))
    @ApiResponse(responseCode = "403", description = "Acesso negado.")
    @PutMapping("/{id}")
    ResponseEntity<ClienteResponse> atualizar(
            @PathVariable Integer id,
            @Valid @RequestBody ClienteRequest request
    );

    @Operation(summary = "Desativar cliente")
    @ApiResponse(responseCode = "204", description = "Cliente desativado com sucesso.")
    @ApiResponse(responseCode = "400", description = "Cliente já está inativo.",
            content = @Content(schema = @Schema()))
    @ApiResponse(responseCode = "404", description = "Cliente não encontrado.",
            content = @Content(schema = @Schema()))
    @ApiResponse(responseCode = "403", description = "Acesso negado.")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> desativar(
            @PathVariable Integer id
    );

}