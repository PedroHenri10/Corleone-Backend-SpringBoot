package com.corleone.entrega.docs;

import com.corleone.entrega.dto.AtualizarStatusEntregaRequest;
import com.corleone.entrega.dto.EntregaFilter;
import com.corleone.entrega.dto.EntregaRequest;
import com.corleone.entrega.dto.EntregaResponse;
import com.corleone.entrega.dto.EntregaResumoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Entrega", description = "Gerenciamento das entregas.")
public interface EntregaApi {

    @Operation(summary = "Cadastrar entrega")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Entrega cadastrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content),
            @ApiResponse(responseCode = "404", description = "Pedido, entregador ou endereço não encontrado", content = @Content)
    })
    ResponseEntity<EntregaResponse> criar(@RequestBody(description = "Dados da entrega", required = true,
                    content = @Content(schema = @Schema(implementation = EntregaRequest.class)))
                                          EntregaRequest request);

    @Operation(summary = "Buscar entrega por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Entrega encontrada"),
            @ApiResponse(responseCode = "404", description = "Entrega não encontrada", content = @Content)
    })
    ResponseEntity<EntregaResponse> buscarPorId(@Parameter(description = "ID da entrega") Integer id);

    @Operation(summary = "Listar entregas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    })
    ResponseEntity<List<EntregaResumoResponse>> listar(
            @RequestBody(
                    description = "Filtros da pesquisa",
                    required = true,
                    content = @Content(schema = @Schema(implementation = EntregaFilter.class))
            )
            EntregaFilter filter
    );

    @Operation(summary = "Iniciar entrega")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Entrega iniciada"),
            @ApiResponse(responseCode = "404", description = "Entrega não encontrada", content = @Content)
    })
    ResponseEntity<EntregaResponse> iniciarEntrega(@Parameter(description = "ID da entrega") Integer id);

    @Operation(summary = "Finalizar entrega")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Entrega finalizada"), @ApiResponse(responseCode = "404", description = "Entrega não encontrada", content = @Content)
    })
    ResponseEntity<EntregaResponse> finalizarEntrega(@Parameter(description = "ID da entrega") Integer id);

    @Operation(summary = "Cancelar entrega")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Entrega cancelada"),
            @ApiResponse(responseCode = "404", description = "Entrega não encontrada", content = @Content)})
    ResponseEntity<EntregaResponse> cancelarEntrega(@Parameter(description = "ID da entrega") Integer id);

    @Operation(summary = "Atualizar status da entrega")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Status atualizado"),
            @ApiResponse(responseCode = "404", description = "Entrega não encontrada", content = @Content)
    })
    ResponseEntity<EntregaResponse> atualizarStatus(@Parameter(description = "ID da entrega") Integer id,
                                                    @RequestBody(
                    description = "Novo status da entrega",
                    required = true,
                    content = @Content(schema = @Schema(implementation = AtualizarStatusEntregaRequest.class))
            )
            AtualizarStatusEntregaRequest request
    );

}