package com.corleone.caixa.docs;

import com.corleone.caixa.dto.CaixaRequest;
import com.corleone.caixa.dto.CaixaResponse;
import com.corleone.caixa.dto.CaixaResumoResponse;
import com.corleone.shared.enums.StatusCaixa;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Tag(name = "Caixa", description = "Operações relacionadas ao controle e movimentação dos caixas da pizzaria.")
@RequestMapping("/v1/api/caixas")
public interface CaixaApi {

    @Operation(summary = "Abrir caixa", description = """
                    Abre um novo caixa para um funcionário.

                    O funcionário não pode possuir outro caixa aberto.
                    O valor de abertura deve ser maior ou igual a zero.
                    """
    )
    @ApiResponses({@ApiResponse(
                    responseCode = "201",
                    description = "Caixa aberto com sucesso.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CaixaResponse.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados da requisição inválidos.",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Funcionário não encontrado.",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "Já existe um caixa aberto para o funcionário.",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "422",
                    description = "Valor de abertura inválido.",
                    content = @Content
            )
    })
    @PostMapping
    ResponseEntity<CaixaResponse> abrir(@Valid @RequestBody CaixaRequest request);

    @Operation(summary = "Fechar caixa", description = """
                    Fecha um caixa que esteja aberto.

                    O valor informado no fechamento é comparado com o valor
                    calculado pelo sistema a partir do valor de abertura e
                    dos lançamentos realizados no caixa.

                    A diferença entre o valor informado e o valor calculado
                    pelo sistema é registrada no caixa.
                    """
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Caixa fechado com sucesso.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CaixaResponse.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Caixa não encontrado.",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "422",
                    description = "Caixa não está aberto ou valor de fechamento inválido.",
                    content = @Content
            )
    })
    @PatchMapping("/{id}/fechar")
    ResponseEntity<CaixaResponse> fechar(
            @Parameter(description = "ID do caixa.", example = "1", required = true, in = ParameterIn.PATH)
            @PathVariable Integer id,

            @Parameter(description = "Valor físico contado no fechamento do caixa.", example = "1500.00", required = true)
            @RequestParam BigDecimal valorFechamento
    );

    @Operation(summary = "Buscar caixa por ID", description = "Consulta os dados completos de um caixa pelo seu identificador.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Caixa encontrado.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CaixaResponse.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Caixa não encontrado.",
                    content = @Content
            )
    })
    @GetMapping("/{id}")
    ResponseEntity<CaixaResponse> buscarPorId(
            @Parameter(description = "ID do caixa.", example = "1", required = true, in = ParameterIn.PATH) @PathVariable Integer id
    );

    @Operation(
            summary = "Listar caixas",
            description = """
                    Lista caixas utilizando filtros opcionais.

                    É possível filtrar por funcionário, status e período
                    de abertura.
                    """
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista de caixas retornada com sucesso.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    type = "array",
                                    implementation = CaixaResumoResponse.class
                            )
                    )
            )
    })
    @GetMapping
    ResponseEntity<List<CaixaResumoResponse>> listar(
            @Parameter(description = "ID do funcionário responsável pelo caixa.", example = "5")
            @RequestParam(required = false) Integer funcionarioId,

            @Parameter(description = "Status do caixa.", example = "ABERTO")
            @RequestParam(required = false) StatusCaixa status,

            @Parameter(description = "Data inicial para filtro da abertura.", example = "2026-09-01")
            @RequestParam(required = false) LocalDate dataInicial,

            @Parameter(description = "Data final para filtro da abertura.", example = "2026-09-30")
            @RequestParam(required = false) LocalDate dataFinal
    );

    @Operation(
            summary = "Listar caixas abertos",
            description = "Retorna os caixas que estão atualmente com status ABERTO."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Caixas abertos retornados com sucesso.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    type = "array",
                                    implementation = CaixaResumoResponse.class
                            )
                    )
            )
    })
    @GetMapping("/abertos")
    ResponseEntity<List<CaixaResumoResponse>> listarAbertos();
}
