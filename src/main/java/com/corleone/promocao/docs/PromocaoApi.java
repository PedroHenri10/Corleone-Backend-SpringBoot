package com.corleone.promocao.docs;

import com.corleone.promocao.dto.PromocaoFilter;
import com.corleone.promocao.dto.PromocaoRequest;
import com.corleone.promocao.dto.PromocaoResponse;
import com.corleone.promocao.dto.PromocaoResumoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Promoção", description = "Gerenciamento de promoções do sistema.")
public interface PromocaoApi {

    @Operation(summary = "Cadastrar promoção", description = "Realiza o cadastro de uma nova promoção.", responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Promoção cadastrada com sucesso.",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = PromocaoResponse.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Produto não encontrado."
                    ),
                    @ApiResponse(
                            responseCode = "409",
                            description = "Produto já possui uma promoção."
                    ),
                    @ApiResponse(
                            responseCode = "422",
                            description = "Dados da promoção inválidos."
                    )
            }
    )
    ResponseEntity<PromocaoResponse> criar(PromocaoRequest request);

    @Operation(summary = "Buscar promoção por ID", description = "Retorna os dados completos de uma promoção.", responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Promoção encontrada.",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = PromocaoResponse.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Promoção não encontrada."
                    )
            }
    )
    ResponseEntity<PromocaoResponse> buscarPorId(@Parameter(description = "ID da promoção.", example = "1") Integer id);

    @Operation(summary = "Listar promoções", description = "Lista promoções utilizando filtros.", responses = {@ApiResponse(
                            responseCode = "200",
                            description = "Lista retornada com sucesso.",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = PromocaoResumoResponse.class
                                    )
                            )
                    )
            }
    )
    ResponseEntity<List<PromocaoResumoResponse>> listar(PromocaoFilter filter);


    @Operation(summary = "Atualizar promoção", description = "Atualiza os dados de uma promoção existente.", responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Promoção atualizada com sucesso.",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = PromocaoResponse.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Promoção ou produto não encontrado."
                    ),
                    @ApiResponse(
                            responseCode = "409",
                            description = "Produto já possui outra promoção."
                    ),
                    @ApiResponse(
                            responseCode = "422",
                            description = "Dados da promoção inválidos."
                    )
            }
    )
    ResponseEntity<PromocaoResponse> atualizar(@Parameter(description = "ID da promoção.", example = "1") Integer id, PromocaoRequest request);

    @Operation(summary = "Ativar promoção", description = "Ativa uma promoção existente.", responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Promoção ativada com sucesso."
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Promoção não encontrada."
                    )
            }
    )
    ResponseEntity<PromocaoResponse> ativar(@Parameter(description = "ID da promoção.", example = "1") Integer id);

    @Operation(summary = "Desativar promoção", description = "Desativa uma promoção existente.", responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Promoção desativada com sucesso."
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Promoção não encontrada."
                    )
            }
    )
    ResponseEntity<PromocaoResponse> desativar(@Parameter(description = "ID da promoção.", example = "1") Integer id);

    @Operation(summary = "Excluir promoção", description = "Remove uma promoção do sistema.", responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Promoção excluída com sucesso."
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Promoção não encontrada."
                    )
            }
    )
    ResponseEntity<Void> excluir(@Parameter(description = "ID da promoção.", example = "1") Integer id);

   
}