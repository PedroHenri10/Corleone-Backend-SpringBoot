package com.corleone.pagamento.docs;

import com.corleone.pagamento.dto.PagamentoFilter;
import com.corleone.pagamento.dto.PagamentoRequest;
import com.corleone.pagamento.dto.PagamentoResponse;
import com.corleone.pagamento.dto.PagamentoResumoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Pagamento", description = "Gerenciamento das formas de pagamento do sistema.")
public interface PagamentoApi {

    @Operation(summary = "Cadastrar forma de pagamento", description = "Realiza o cadastro de uma nova forma de pagamento.",
            responses = {
                @ApiResponse(responseCode = "200", description = "Forma de pagamento cadastrada com sucesso.",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = PagamentoResponse.class
                                    )
                            )
                    ),
                    @ApiResponse(responseCode = "409", description = "Forma de pagamento já cadastrada."),
                    @ApiResponse(responseCode = "422", description = "Dados da forma de pagamento inválidos.")
            }
    )
    ResponseEntity<PagamentoResponse> criar(PagamentoRequest request);

    @Operation(
            summary = "Buscar forma de pagamento por ID",
            description = "Retorna os dados completos de uma forma de pagamento.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Forma de pagamento encontrada.",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = PagamentoResponse.class
                                    )
                            )
                    ),
                    @ApiResponse(responseCode = "404", description = "Forma de pagamento não encontrada.")
            }
    )
    ResponseEntity<PagamentoResponse> buscarPorId(@Parameter(description = "ID da forma de pagamento.", example = "1") Integer id);

    @Operation(
            summary = "Listar formas de pagamento",
            description = "Lista formas de pagamento utilizando filtros.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Lista retornada com sucesso.",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = PagamentoResumoResponse.class
                                    )
                            )
                    )
            }
    )
    ResponseEntity<List<PagamentoResumoResponse>> listar(PagamentoFilter filter);

    @Operation(
            summary = "Listar formas de pagamento ativas",
            description = "Retorna somente as formas de pagamento que estão ativas.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Lista retornada com sucesso.",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = PagamentoResumoResponse.class
                                    )
                            )
                    )
            }
    )
    ResponseEntity<List<PagamentoResumoResponse>> listarAtivos();

    @Operation(
            summary = "Atualizar forma de pagamento",
            description = "Atualiza os dados de uma forma de pagamento ativa.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Forma de pagamento atualizada com sucesso.",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = PagamentoResponse.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Forma de pagamento não encontrada."
                    ),
                    @ApiResponse(
                            responseCode = "409",
                            description = "Já existe uma forma de pagamento com esse nome."
                    ),
                    @ApiResponse(
                            responseCode = "422",
                            description = "A forma de pagamento está inativa."
                    )
            }
    )
    ResponseEntity<PagamentoResponse> atualizar(@Parameter(description = "ID da forma de pagamento.", example = "1") Integer id, PagamentoRequest request);

    @Operation(
            summary = "Ativar forma de pagamento",
            description = "Ativa uma forma de pagamento previamente desativada.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Forma de pagamento ativada com sucesso.",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = PagamentoResponse.class
                                    )
                            )
                    ),
                    @ApiResponse(responseCode = "404", description = "Forma de pagamento não encontrada.")
            }
    )
    ResponseEntity<PagamentoResponse> ativar(@Parameter(description = "ID da forma de pagamento.", example = "1") Integer id);

    @Operation(
            summary = "Desativar forma de pagamento",
            description = "Realiza a desativação lógica de uma forma de pagamento.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Forma de pagamento desativada com sucesso.",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = PagamentoResponse.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Forma de pagamento não encontrada."
                    ),
                    @ApiResponse(
                            responseCode = "422",
                            description = "A forma de pagamento já está inativa."
                    )
            }
    )
    ResponseEntity<PagamentoResponse> desativar(@Parameter(description = "ID da forma de pagamento.", example = "1") Integer id);
}
