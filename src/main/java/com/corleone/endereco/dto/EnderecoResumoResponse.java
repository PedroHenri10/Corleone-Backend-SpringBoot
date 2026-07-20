package com.corleone.endereco.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Resumo de um endereço.")
public class EnderecoResumoResponse {

    @Schema(example = "1")
    private Integer id;

    @Schema(example = "Rua das Flores")
    private String logradouro;

    @Schema(example = "120")
    private Integer numero;

    @Schema(example = "Centro")
    private String bairro;

    @Schema(example = "Campinas")
    private String cidade;

    @Schema(example = "SP")
    private String estado;
}
