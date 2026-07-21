package com.corleone.usuario.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados para criação ou atualização de um usuário.")
public class UsuarioRequest {

    @NotNull
    @Schema(description = "Funcionário vinculado ao usuário.", example = "1")
    private Integer funcionarioId;

    @NotBlank
    @Schema(description = "Login do usuário.", example = "ana")
    private String login;

    @NotBlank
    @Schema(description = "Senha do usuário.", example = "123456")
    private String senha;

    @Schema(description = "Obrigar troca de senha no primeiro acesso.", example = "true")
    private Boolean trocarSenha;

    @Schema(description = "Lista de papéis (roles).", example = "[1,2]")
    private List<Integer> roles;
}