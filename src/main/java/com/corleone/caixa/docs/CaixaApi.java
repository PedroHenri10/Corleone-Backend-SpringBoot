package com.corleone.caixa.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    @PostMapping
    ResponseEntity<CaixaResponse> abrir(
            @Valid @RequestBody CaixaRequest request
    );
}
