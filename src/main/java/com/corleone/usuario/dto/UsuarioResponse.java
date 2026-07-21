package com.corleone.usuario.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados retornados do usuário.")
public class UsuarioResponse {

    @Schema(example = "1")
    private Integer id;

    @Schema(example = "Leonardo")
    private String login;

    @Schema(example = "true")
    private Boolean ativo;

    @Schema(example = "false")
    private Boolean trocarSenha;

    @Schema(example = "2026-07-20T10:30:00")
    private LocalDateTime ultimoAcesso;

    @Schema(example = "2026-07-20T10:30:00")
    private LocalDateTime dataCriacao;

    @Schema(example = "15")
    private Integer funcionarioId;

    @Schema(example = "Leonardo Almeida")
    private String funcionarioNome;

    @Schema(description = "Papéis do usuário.")
    private List<String> roles;
}