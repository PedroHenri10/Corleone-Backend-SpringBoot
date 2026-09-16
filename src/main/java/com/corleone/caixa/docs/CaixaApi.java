package com.corleone.caixa.docs;

import com.corleone.caixa.dto.CaixaRequest;
import com.corleone.caixa.dto.CaixaResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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

    
}
