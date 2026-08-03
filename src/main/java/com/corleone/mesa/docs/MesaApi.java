package com.corleone.mesa.docs;

import com.corleone.mesa.dto.MesaFilter;
import com.corleone.mesa.dto.MesaRequest;
import com.corleone.mesa.dto.MesaResponse;
import com.corleone.mesa.dto.MesaResumoResponse;
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

@Tag(name = "Mesa", description = "Gerenciamento de Mesas do sistema.")
public interface MesaApi {
    @Operation(summary = "Cadastrar mesa", description = "Realiza o cadastro de uma nova mesa..",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Mesa cadastrada com sucesso.", content = @Content(
                            schema = @Schema(implementation = MesaResponse.class))),
                    @ApiResponse(responseCode = "409", description = "Mesa já cadastrada.")
            }
    )
    ResponseEntity<MesaResponse> criar(MesaRequest request);

    @Operation(
            summary = "Buscar mesa por ID",
            description = "Retorna os dados completos de uma mesa.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Mesa encontrada.", content = @Content(
                            schema = @Schema(implementation = MesaResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Mesa não encontrada.")
            }
    )
    ResponseEntity<MesaResponse> buscarPorId(@Parameter(description = "ID da mesa.", example = "1") Integer id);

    @Operation(summary = "Listar mesas", description = "Lista mesas utilizando paginação e filtros.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso.", content = @Content(
                            array = @ArraySchema(
                                    schema = @Schema(implementation = MesaResumoResponse.class))))
            }
    )
    ResponseEntity<List<MesaResumoResponse>> listar(MesaFilter filtro);

    @Operation(summary = "Atualizar mesa", description = "Atualiza os dados de uma mesa.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Mesa atualizada."),
                    @ApiResponse(responseCode = "404", description = "Mesa não encontrada."),
                    @ApiResponse(responseCode = "409", description = "Já existe uma mesa com esse número."),
                    @ApiResponse(responseCode = "422", description = "A operação não pode ser realizada porque a mesa está inativa.")
            }
    )
    ResponseEntity<MesaResponse> atualizar(@Parameter(description = "ID da mesa.", example = "1") Integer id, MesaRequest request);

    @Operation(summary = "Desativar mesa", description = "Realiza a exclusão lógica da mesa.",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Mesa desativada."),
                    @ApiResponse(responseCode = "404", description = "Mesa não encontrada."),
                    @ApiResponse(responseCode = "422", description = "Mesa já inativq.", content = @Content(schema = @Schema(hidden = true)))
            }
    )
    ResponseEntity<Void> desativar(@Parameter(description = "ID da mesa.", example = "1") Integer id);

    @Operation(
            summary = "Abrir mesa",
            description = "Altera o status da mesa para OCUPADA.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Mesa aberta com sucesso.",
                            content = @Content(schema = @Schema(implementation = MesaResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Mesa não encontrada."),
                    @ApiResponse(responseCode = "422", description = "Mesa inativa ou indisponível.")
            }
    )
    ResponseEntity<MesaResponse> abrirMesa(@Parameter(description = "ID da mesa.", example = "1") Integer id);

    @Operation(summary = "Fechar mesa", description = "Altera o status da mesa para LIVRE.", responses = {
                    @ApiResponse(responseCode = "200", description = "Mesa fechada com sucesso.",
                            content = @Content(schema = @Schema(implementation = MesaResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Mesa não encontrada."),
                    @ApiResponse(responseCode = "422", description = "Mesa não está ocupada.")
            }
    )
    ResponseEntity<MesaResponse> fecharMesa(@Parameter(description = "ID da mesa.", example = "1") Integer id);

    @Operation(summary = "Reservar mesa", description = "Altera o status da mesa para RESERVADA.", responses = {
                    @ApiResponse(responseCode = "200", description = "Mesa reservada com sucesso.",
                            content = @Content(schema = @Schema(implementation = MesaResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Mesa não encontrada."),
                    @ApiResponse(responseCode = "422", description = "Mesa inativa ou indisponível.")
            }
    )
    ResponseEntity<MesaResponse> reservarMesa(@Parameter(description = "ID da mesa.", example = "1") Integer id);

    @Operation(summary = "Cancelar reserva", description = "Cancela a reserva da mesa, retornando seu status para LIVRE.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Reserva cancelada com sucesso.",
                            content = @Content(schema = @Schema(implementation = MesaResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Mesa não encontrada."),
                    @ApiResponse(responseCode = "422", description = "Mesa não está reservada.")
            }
    )
    ResponseEntity<MesaResponse> cancelarReserva(@Parameter(description = "ID da mesa.", example = "1") Integer id);

}
