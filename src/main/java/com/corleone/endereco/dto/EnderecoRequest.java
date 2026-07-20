package com.corleone.endereco.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados para cadastro e atualização de um endereço.")
public class EnderecoRequest {

    @Schema(description = "Logradouro.", example = "Rua das Flores")
    @NotBlank
    @Size(max = 150)
    private String logradouro;

    @Schema(description = "Número do imóvel.", example = "120")
    @NotNull
    @Positive
    private Integer numero;

    @Schema(description = "Complemento.", example = "Apartamento 302")
    @Size(max = 100)
    private String complemento;

    @Schema(description = "Bairro.", example = "Centro")
    @NotBlank
    @Size(max = 50)
    private String bairro;

    @Schema(description = "Cidade.", example = "Campinas")
    @NotBlank
    @Size(max = 50)
    private String cidade;

    @Schema(description = "UF.", example = "SP")
    @NotBlank
    @Size(min = 2, max = 2)
    private String estado;
}
