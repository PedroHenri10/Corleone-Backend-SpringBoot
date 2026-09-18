package com.corleone.caixa.docs;

import com.corleone.caixa.dto.LancamentoCaixaRequest;
import com.corleone.caixa.dto.LancamentoCaixaResponse;
import com.corleone.caixa.dto.LancamentoCaixaResumoResponse;
import com.corleone.shared.enums.TipoLancamentoCaixa;
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

import java.time.LocalDate;
import java.util.List;

@Tag(name = "Lançamentos de Caixa", description = "Operações relacionadas aos lançamentos realizados nos caixas.")
@RequestMapping("/v1/api/lancamentos-caixa")
public interface LancamentoCaixaApi {

    @Operation(summary = "Criar lançamento de caixa", description = """
                    Registra um novo lançamento em um caixa aberto.

                    O lançamento pode estar relacionado a um pedido,
                    forma de pagamento e funcionário.
                    """
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Lançamento criado com sucesso.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = LancamentoCaixaResponse.class
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados da requisição inválidos.",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Caixa, funcionário, pedido ou pagamento não encontrado.",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "422",
                    description = "Não é permitido realizar lançamento no caixa.",
                    content = @Content
            )
    })
    @PostMapping
    ResponseEntity<LancamentoCaixaResponse> criar(@Valid @RequestBody LancamentoCaixaRequest request);

    @Operation(summary = "Buscar lançamento por ID", description = "Consulta um lançamento de caixa pelo seu identificador.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Lançamento encontrado.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = LancamentoCaixaResponse.class
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Lançamento não encontrado.",
                    content = @Content
            )
    })
    @GetMapping("/{id}")
    ResponseEntity<LancamentoCaixaResponse> buscarPorId(@Parameter(
                    description = "ID do lançamento.",
                    example = "1",
                    required = true,
                    in = ParameterIn.PATH
    ) @PathVariable Integer id);

    @Operation(summary = "Listar lançamentos", description = """
                    Lista os lançamentos de caixa utilizando filtros opcionais.

                    É possível filtrar por caixa, funcionário, pedido,
                    forma de pagamento, tipo e período.
                    """
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Lançamentos retornados com sucesso.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    type = "array",
                                    implementation = LancamentoCaixaResumoResponse.class
                            )
                    )
            )
    })
    @GetMapping ResponseEntity<List<LancamentoCaixaResumoResponse>> listar(
            @Parameter(description = "ID do caixa.", example = "1")
            @RequestParam(required = false) Integer caixaId,

            @Parameter(description = "ID do funcionário.", example = "5")
            @RequestParam(required = false) Integer funcionarioId,

            @Parameter(description = "ID do pedido.", example = "10")
            @RequestParam(required = false) Integer pedidoId,

            @Parameter(description = "ID da forma de pagamento.", example = "2")
            @RequestParam(required = false) Integer pagamentoId,

            @Parameter(description = "Tipo do lançamento.", example = "ENTRADA")
            @RequestParam(required = false) TipoLancamentoCaixa tipo,

            @Parameter(description = "Data inicial.", example = "2026-09-01")
            @RequestParam(required = false) LocalDate dataInicial,

            @Parameter(description = "Data final.", example = "2026-09-30")
            @RequestParam(required = false) LocalDate dataFinal
    );
}
