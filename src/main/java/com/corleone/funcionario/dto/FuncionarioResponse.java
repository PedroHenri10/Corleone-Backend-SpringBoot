package com.corleone.funcionario.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO de retorno de funcionário.")
public class FuncionarioResponse {

    @Schema(description = "Identificador do funcionário.", example = "1")
    private Integer id;

    @Schema(description = "Nome.", example = "Andre Roberto Silveira")
    private String nome;

    @Schema(description = "CPF.", example = "123.456.789-00")
    private String cpf;

    @Schema(description = "RG.", example = "123456789")
    private String rg;

    @Schema(description = "Data de nascimento.", example = "2000-05-18")
    private LocalDate dataNascimento;

    @Schema(description = "Telefone.", example = "(19)99999-9999")
    private String telefone;

    @Schema(description = "E-mail.", example = "andre@email.com")
    private String email;

    @Schema(description = "Salário.", example = "2500.00")
    private BigDecimal salario;

    @Schema(description = "Data de admissão.", example = "2025-01-10")
    private LocalDate dataAdmissao;

    @Schema(description = "Data de demissão.", example = "2026-02-20")
    private LocalDate dataDemissao;

    @Schema(description = "Funcionário ativo.", example = "true")
    private Boolean ativo;

    @Schema(description = "Data de criação.", example = "2026-07-16T14:30:00")
    private LocalDateTime dataCriacao;

    @Schema(description = "Data de atualização.", example = "2026-07-16T14:30:00")
    private LocalDateTime dataAtualizacao;

    @Schema(description = "Identificador do cargo.", example = "2")
    private Integer cargoId;

    @Schema(description = "Nome do cargo.", example = "Gerente")
    private String cargoNome;

    @Schema(description = "Identificador do endereço.", example = "5")
    private Integer enderecoId;

}