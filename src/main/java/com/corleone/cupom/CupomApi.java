package com.corleone.cupom;

import com.corleone.cupom.dto.CupomRequest;
import com.corleone.cupom.dto.CupomResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Cupom", description = "Gerenciamento de cupons do sistema.")
public interface CupomApi {

    @Operation(summary = "Cadastrar cupom", description = "Realiza o cadastro de um novo cupom.",
            responses = {@ApiResponse(responseCode = "200", description = "Cupom cadastrado com sucesso.",
                            content = @Content(
                                    schema = @Schema(implementation = CupomResponse.class)
                            )
                    ),
                    @ApiResponse(responseCode = "409", description = "Já existe um cupom com esse código."),
                    @ApiResponse(responseCode = "422", description = "Período ou valor mínimo do cupom inválido.")
            }
    )
    ResponseEntity<CupomResponse> criar(CupomRequest request);
    
}
