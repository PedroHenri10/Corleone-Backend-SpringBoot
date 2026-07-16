package com.corleone.funcionario.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Resumo de funcionário utilizado em listagens e seleções.")
public class FuncionarioResumoResponse {

    @Schema(description = "Identificador do funcionário.", example = "1")
    private Integer id;

    @Schema(description = "Nome do funcionário.", example = "Carol Antonella Silva")
    private String nome;

    @Schema(description = "CPF.", example = "123.456.789-00")
    private String cpf;

    @Schema(description = "Nome do cargo.", example = "Gerente")
    private String cargo;

    @Schema(description = "Situação do funcionário.", example = "true")
    private Boolean ativo;

}