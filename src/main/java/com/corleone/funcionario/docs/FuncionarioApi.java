package com.corleone.funcionario.docs;

import com.corleone.categoria.dto.CategoriaResponse;
import com.corleone.funcionario.dto.FuncionarioFiltro;
import com.corleone.funcionario.dto.FuncionarioRequest;
import com.corleone.funcionario.dto.FuncionarioResponse;
import com.corleone.funcionario.dto.FuncionarioResumoResponse;
import com.corleone.usuario.dto.UsuarioResumoResponse;
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

@Tag(name = "Funcionários", description = "Gerenciamento de funcionários do sistema.")
public interface FuncionarioApi {

    @Operation(summary = "Cadastrar funcionário", description = "Realiza o cadastro de um novo funcionário.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Funcionário cadastrado com sucesso.", content = @Content(
                            schema = @Schema(implementation = FuncionarioResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos."),
                    @ApiResponse(responseCode = "409", description = "CPF ou e-mail já cadastrados.")
            }
    )
    ResponseEntity<FuncionarioResponse> criar(FuncionarioRequest request);

    @Operation(
            summary = "Buscar funcionário por ID",
            description = "Retorna os dados completos de um funcionário.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Funcionário encontrado.", content = @Content(
                            schema = @Schema(implementation = FuncionarioResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Funcionário não encontrado.")
            }
    )
    ResponseEntity<FuncionarioResponse> buscarPorId(@Parameter(description = "ID do funcionário.", example = "1") Integer id);

    @Operation(summary = "Listar funcionários", description = "Lista funcionários utilizando paginação e filtros.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso.", content = @Content(
                            array = @ArraySchema(
                                    schema = @Schema(implementation = FuncionarioResumoResponse.class))))
            }
    )
    ResponseEntity<Page<FuncionarioResumoResponse>> listar(FuncionarioFiltro filtro, Pageable pageable);

    @Operation(summary = "Atualizar funcionário", description = "Atualiza os dados de um funcionário.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Funcionário atualizado."),
                    @ApiResponse(responseCode = "404", description = "Funcionário não encontrado."),
                    @ApiResponse(responseCode = "409", description = "CPF ou e-mail já cadastrados.")
            }
    )
    ResponseEntity<FuncionarioResponse> atualizar(@Parameter(description = "ID do funcionário.", example = "1") Integer id,
                                  FuncionarioRequest request);

    @Operation(summary = "Desativar funcionário", description = "Realiza a exclusão lógica do funcionário.",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Funcionário desativado."),
                    @ApiResponse(responseCode = "404", description = "Funcionário não encontrado."),
                    @ApiResponse(responseCode = "422", description = "Funcionário já inativo.", content = @Content(schema = @Schema(hidden = true)))
            }
    )
    ResponseEntity<Void> desativar(@Parameter(description = "ID do funcionário.", example = "1") Integer id);

}