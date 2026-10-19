package com.corleone.pedido.docs;

import com.corleone.pedido.dto.ItemPedidoFilter;
import com.corleone.pedido.dto.ItemPedidoRequest;
import com.corleone.pedido.dto.ItemPedidoResponse;
import com.corleone.pedido.dto.ItemPedidoResumoResponse;
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

import java.util.List;

@Tag(name = "Itens do Pedido", description = "Gerenciamento dos itens de cada pedido.")
public interface ItemPedidoApi {

    @Operation(summary = "Adicionar item ao pedido", description = "Adiciona um produto a um pedido existente.", responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Item adicionado com sucesso.",
                            content = @Content(schema = @Schema(implementation = ItemPedidoResponse.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos."),
                    @ApiResponse(responseCode = "404", description = "Pedido ou produto não encontrado."),
                    @ApiResponse(responseCode = "422", description = "Pedido não pode ser editado ou quantidade inválida.")
            }
    )
    ResponseEntity<ItemPedidoResponse> criar(@Parameter(description = "ID do pedido.", example = "1")
            Integer pedidoId,
            ItemPedidoRequest request
    );

    @Operation(
            summary = "Listar itens",
            description = "Lista os itens utilizando paginação e filtros.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Itens retornados com sucesso.",
                            content = @Content(
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = ItemPedidoResumoResponse.class)
                                    )
                            )
                    )
            }
    )
    ResponseEntity<Page<ItemPedidoResumoResponse>> listar(
            ItemPedidoFilter filtro,
            Pageable pageable
    );

    @Operation(
            summary = "Listar itens de um pedido",
            description = "Retorna todos os itens associados ao pedido informado.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Itens retornados com sucesso.",
                            content = @Content(
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = ItemPedidoResponse.class)
                                    )
                            )
                    ),
                    @ApiResponse(responseCode = "404", description = "Pedido não encontrado.")
            }
    )
    ResponseEntity<List<ItemPedidoResponse>> listarPorPedido(
            @Parameter(description = "ID do pedido.", example = "1")
            Integer pedidoId
    );

    @Operation(
            summary = "Atualizar item",
            description = "Atualiza o produto, a quantidade ou a observação de um item do pedido.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Item atualizado com sucesso.",
                            content = @Content(
                                    schema = @Schema(implementation = ItemPedidoResponse.class)
                            )
                    ),
                    @ApiResponse(responseCode = "404", description = "Item ou produto não encontrado."),
                    @ApiResponse(responseCode = "422", description = "Pedido não pode ser editado ou quantidade inválida.")
            }
    )
    ResponseEntity<ItemPedidoResponse> atualizar(@Parameter(description = "ID do item do pedido.", example = "1") Integer id, ItemPedidoRequest request);

    @Operation(
            summary = "Remover item",
            description = "Remove um item de um pedido que ainda pode ser editado.",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Item removido com sucesso."),
                    @ApiResponse(responseCode = "404", description = "Item não encontrado."),
                    @ApiResponse(responseCode = "422", description = "Pedido não pode ser editado.")
            }
    )
    ResponseEntity<Void> remover(@Parameter(description = "ID do item do pedido.", example = "1") Integer id);
}