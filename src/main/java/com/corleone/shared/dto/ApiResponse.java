package com.corleone.shared.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Estrutura padrão de resposta para todas as APIs do sistema")
public class ApiResponse<T> {

    @Schema(description = "Indica se a operação foi executada com sucesso", example = "true")
    private Boolean success;

    @Schema(description = "Mensagem descritiva sobre o resultado da operação", example = "Operação realizada com sucesso")
    private String message;

    @Schema(description = "Dados específicos retornados pela requisição (Varia de acordo com o endpoint)")
    private T data;
}
