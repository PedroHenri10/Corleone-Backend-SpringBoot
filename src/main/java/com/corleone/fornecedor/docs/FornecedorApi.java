package com.corleone.fornecedor.docs;

import com.corleone.exceptionhandler.ErrorResponse;
import com.corleone.fornecedor.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Fornecedor", description = "Gerenciamento de fornecedores.")
public interface FornecedorApi {

    @Operation(summary = "Cadastrar fornecedor", description = "Realiza o cadastro de um novo fornecedor.")
    @ApiResponse(responseCode = "201", description = "Fornecedor cadastrado.")
    @ApiResponse(responseCode = "400", description = "Dados inválidos.", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @PostMapping ResponseEntity<FornecedorResponse> criar(@Valid @RequestBody FornecedorRequest request);

    @Operation(summary = "Buscar fornecedor por id")
    @ApiResponse(responseCode = "200", description = "Fornecedor encontrado.")
    @ApiResponse(responseCode = "404", description = "Fornecedor não encontrado.")
    @GetMapping("/{id}")
    ResponseEntity<FornecedorResponse> buscarPorId(@Parameter(description = "Id do fornecedor") @PathVariable Integer id);

    @Operation(summary = "Listar fornecedores")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso.")
    @GetMapping
    ResponseEntity<Page<FornecedorResumoResponse>> listar(FornecedorFiltro filtro, Pageable pageable);

    @Operation(summary = "Atualizar fornecedor")
    @ApiResponse(responseCode = "200", description = "Fornecedor atualizado com sucesso.")
    @ApiResponse(responseCode = "400", description = "Dados inválidos ou regra de negócio violada.", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "404", description = "Fornecedor não encontrado.", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @PutMapping("/{id}")
    ResponseEntity<FornecedorResponse> atualizar(@PathVariable Integer id, @Valid @RequestBody FornecedorRequest request);

    @Operation(summary = "Desativar fornecedor")
    @ApiResponse(responseCode = "204", description = "Fornecedor desativado com sucesso.")
    @ApiResponse(responseCode = "404", description = "Fornecedor não encontrado.", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "422", description = "Fornecedor já inativo.")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> desativar(@PathVariable Integer id);

}