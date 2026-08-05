package com.corleone.avaliacao.docs;

package com.corleone.avaliacao.docs;

import com.corleone.avaliacao.dto.AvaliacaoFilter;
import com.corleone.avaliacao.dto.AvaliacaoRequest;
import com.corleone.avaliacao.dto.AvaliacaoResponse;
import com.corleone.avaliacao.dto.AvaliacaoResumoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Avaliação", description = "Gerenciamento de avaliações dos pedidos.")
public interface AvaliacaoApi {

    @Operation(summary = "Cadastrar avaliação", description = "Realiza o cadastro de uma nova avaliação para um pedido.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Avaliação cadastrada com sucesso.",
                            content = @Content(schema = @Schema(implementation = AvaliacaoResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Pedido ou cliente não encontrado."),
                    @ApiResponse(responseCode = "400", description = "Nota inválida."),
                    @ApiResponse(responseCode = "409", description = "O pedido já possui uma avaliação.")
            }
    )
    ResponseEntity<AvaliacaoResponse> criar(AvaliacaoRequest request);


}