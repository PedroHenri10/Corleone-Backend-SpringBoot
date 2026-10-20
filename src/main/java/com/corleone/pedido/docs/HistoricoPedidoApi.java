package com.corleone.pedido.docs;

import com.corleone.pedido.dto.HistoricoPedidoFilter;
import com.corleone.pedido.dto.HistoricoPedidoResponse;
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

@Tag(name = "Histórico de Pedidos", description = "Consulta do histórico de alterações dos pedidos.")
public interface HistoricoPedidoApi {

    @Operation(
            summary = "Buscar histórico por ID",
            description = "Retorna um registro específico do histórico de um pedido.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Registro encontrado.",
                            content = @Content(
                                    schema = @Schema(implementation = HistoricoPedidoResponse.class)
                            )
                    ),
                    @ApiResponse(responseCode = "404", description = "Registro não encontrado.")
            }
    )
    ResponseEntity<HistoricoPedidoResponse> buscarPorId(@Parameter(description = "ID do registro de histórico.", example = "1") Integer id);

   
}