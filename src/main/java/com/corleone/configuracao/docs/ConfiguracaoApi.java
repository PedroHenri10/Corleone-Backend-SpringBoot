package com.corleone.configuracao.docs;

import com.corleone.configuracao.dto.ConfiguracaoRequest;
import com.corleone.configuracao.dto.ConfiguracaoResponse;
import com.corleone.configuracao.dto.ConfiguracaoResumoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Configuração", description = "Gerenciamento das configurações do sistema.")
public interface ConfiguracaoApi {

    @Operation(summary = "Cadastrar configuração", description = "Realiza o cadastro de uma nova configuração.",
            responses = {@ApiResponse(
                            responseCode = "200",
                            description = "Configuração cadastrada com sucesso.",
                            content = @Content(schema = @Schema(implementation = ConfiguracaoResponse.class)
                            )
                    ),
                    @ApiResponse(responseCode = "409", description = "Já existe uma configuração com essa chave.")
            }
    )
    ResponseEntity<ConfiguracaoResponse> criar(ConfiguracaoRequest request);

    @Operation(summary = "Buscar configuração por ID", description = "Retorna os dados completos de uma configuração.",
            responses = {@ApiResponse(
                            responseCode = "200",
                            description = "Configuração encontrada.",
                            content = @Content(schema = @Schema(implementation = ConfiguracaoResponse.class)
                            )
                    ),
                    @ApiResponse(responseCode = "404", description = "Configuração não encontrada.")
            }
    )
    ResponseEntity<ConfiguracaoResponse> buscarPorId(@Parameter(description = "ID da configuração.", example = "1") Integer id);

    @Operation(summary = "Buscar configuração por chave", description = "Retorna uma configuração utilizando sua chave.",
            responses = {@ApiResponse(responseCode = "200", description = "Configuração encontrada.",
                            content = @Content(schema = @Schema(implementation = ConfiguracaoResponse.class)
                            )
                    ),
                    @ApiResponse(responseCode = "404", description = "Configuração não encontrada.")
            }
    )
    ResponseEntity<ConfiguracaoResponse> buscarPorChave(@Parameter(description = "Chave da configuração.", example = "TAXA_ENTREGA")
            String chave);

    @Operation(summary = "Listar configurações", description = "Retorna todas as configurações cadastradas.",
            responses = {@ApiResponse(
                            responseCode = "200",
                            description = "Configurações retornadas com sucesso.",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ConfiguracaoResumoResponse.class)
                                    )
                            )
                    )
            }
    )
    ResponseEntity<List<ConfiguracaoResumoResponse>> listar();

    @Operation(summary = "Atualizar configuração", description = "Atualiza os dados de uma configuração existente.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Configuração atualizada com sucesso.",
                            content = @Content(schema = @Schema(implementation = ConfiguracaoResponse.class)
                            )
                    ),
                    @ApiResponse(responseCode = "404", description = "Configuração não encontrada."),
                    @ApiResponse(responseCode = "409", description = "Já existe uma configuração com essa chave.")
            }
    )
    ResponseEntity<ConfiguracaoResponse> atualizar(
            @Parameter(description = "ID da configuração.", example = "1") Integer id, ConfiguracaoRequest request);

    @Operation(summary = "Excluir configuração", description = "Exclui uma configuração do sistema.",
            responses = {@ApiResponse(responseCode = "204", description = "Configuração excluída com sucesso."),
                    @ApiResponse(responseCode = "404", description = "Configuração não encontrada.")
            }
    )
    ResponseEntity<Void> excluir(@Parameter(description = "ID da configuração.", example = "1") Integer id);
}