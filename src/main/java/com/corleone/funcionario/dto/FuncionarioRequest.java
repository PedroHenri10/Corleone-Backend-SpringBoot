package com.corleone.funcionario.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO utilizado para cadastro e atualização de funcionários.")
public class FuncionarioRequest {

    @NotBlank
    @Size(max = 150)
    @Schema(description = "Nome completo do funcionário.", example = "Carol Antonelle Silva")
    private String nome;

    @NotBlank
    @Size(max = 14)
    @Schema(description = "CPF do funcionário.", example = "123.456.789-00")
    private String cpf;

    @Size(max = 20)
    @Schema(description = "RG do funcionário.", example = "123456789")
    private String rg;

    @NotNull
    @Schema(description = "Data de nascimento.", example = "2000-05-18")
    private LocalDate dataNascimento;

    @Size(max = 20)
    @Schema(description = "Telefone.", example = "(19) 99999-9999")
    private String telefone;

    @Email
    @Size(max = 120)
    @Schema(description = "E-mail.", example = "carol@email.com")
    private String email;

    @PositiveOrZero
    @Schema(description = "Salário do funcionário.", example = "2500.00")
    private BigDecimal salario;

    @NotNull
    @Schema(description = "Data de admissão.", example = "2025-01-10")
    private LocalDate dataAdmissao;

    @Schema(description = "Data de demissão.", example = "2026-02-20")
    private LocalDate dataDemissao;

    @NotNull
    @Schema(description = "Identificador do cargo.", example = "1")
    private Integer cargoId;

    @Schema(description = "Identificador do endereço.", example = "3")
    private Integer enderecoId;

}