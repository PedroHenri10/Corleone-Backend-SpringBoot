package com.corleone.caixa.docs;

import com.corleone.caixa.dto.LancamentoCaixaRequest;
import com.corleone.caixa.dto.LancamentoCaixaResponse;
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

}
