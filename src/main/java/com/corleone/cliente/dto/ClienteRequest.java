package com.corleone.cliente.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados para cadastro e atualização de cliente.")
public class ClienteRequest {

    @NotBlank
    @Size(max = 100)
    @Schema(description = "Nome do cliente.", example = "João da Silva")
    private String nome;

    @NotBlank
    @Size(max = 20)
    @Schema(description = "Telefone principal.", example = "(19) 99999-9999")
    private String telefone1;

    @Size(max = 20)
    @Schema(description = "Telefone secundário.", example = "(19) 98888-8888")
    private String telefone2;

    @NotBlank
    @Email
    @Size(max = 100)
    @Schema(description = "E-mail.", example = "joao@email.com")
    private String email;

    @Size(max = 50)
    @Schema(description = "Status do cliente.", example = "ATIVO")
    private String status;

    @NotNull
    @Schema(description = "Identificador do endereço.", example = "1")
    private Integer enderecoId;

}