package com.corleone.pedido.docs;

import com.corleone.pedido.dto.PedidoFilter;
import com.corleone.pedido.dto.PedidoRequest;
import com.corleone.pedido.dto.PedidoResponse;
import com.corleone.pedido.dto.PedidoResumoResponse;
import com.corleone.shared.enums.StatusPedido;
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

@Tag(name = "Pedidos", description = "Gerenciamento de pedidos da pizzaria.")
public interface PedidoApi {

    @Operation(
            summary = "Cadastrar pedido",
            description = "Realiza o cadastro de um novo pedido.",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Pedido cadastrado com sucesso.",
                            content = @Content(
                                    schema = @Schema(implementation = PedidoResponse.class)
                            )
                    ),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos."),
                    @ApiResponse(responseCode = "404", description = "Cliente, funcionário ou recurso relacionado não encontrado.")
            }
    )
    ResponseEntity<PedidoResponse> criar(PedidoRequest request);

    @Operation(
            summary = "Buscar pedido por ID",
            description = "Retorna os dados completos de um pedido.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Pedido encontrado.",
                            content = @Content(
                                    schema = @Schema(implementation = PedidoResponse.class)
                            )
                    ),
                    @ApiResponse(responseCode = "404", description = "Pedido não encontrado.")
            }
    )
    ResponseEntity<PedidoResponse> buscarPorId(
            @Parameter(description = "ID do pedido.", example = "1")
            Integer id
    );

    @Operation(
            summary = "Listar pedidos",
            description = "Lista pedidos com paginação e filtros.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Pedidos retornados com sucesso.",
                            content = @Content(
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = PedidoResumoResponse.class)
                                    )
                            )
                    )
            }
    )
    ResponseEntity<Page<PedidoResumoResponse>> listar(PedidoFilter filtro, Pageable pageable);


}