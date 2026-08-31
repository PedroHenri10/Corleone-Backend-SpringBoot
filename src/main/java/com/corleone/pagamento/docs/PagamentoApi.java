package com.corleone.pagamento.docs;

import com.corleone.pagamento.dto.PagamentoRequest;
import com.corleone.pagamento.dto.PagamentoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Pagamento", description = "Gerenciamento das formas de pagamento do sistema.")
public interface PagamentoApi {

    @Operation(summary = "Cadastrar forma de pagamento", description = "Realiza o cadastro de uma nova forma de pagamento.",
            responses = {
                @ApiResponse(responseCode = "200", description = "Forma de pagamento cadastrada com sucesso.",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = PagamentoResponse.class
                                    )
                            )
                    ),
                    @ApiResponse(responseCode = "409", description = "Forma de pagamento já cadastrada."),
                    @ApiResponse(responseCode = "422", description = "Dados da forma de pagamento inválidos.")
            }
    )
    ResponseEntity<PagamentoResponse> criar(PagamentoRequest request);
}
