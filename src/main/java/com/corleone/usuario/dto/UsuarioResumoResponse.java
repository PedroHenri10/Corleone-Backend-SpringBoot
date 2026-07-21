package com.corleone.usuario.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Resumo dos usuários.")
public class UsuarioResumoResponse {

    @Schema(example = "1")
    private Integer id;

    @Schema(example = "Gabriela")
    private String login;

    @Schema(example = "Gabriela Neves")
    private String funcionario;

    @Schema(example = "true")
    private Boolean ativo;
}