package com.corleone.usuario.entity;

import com.corleone.funcionario.entity.Funcionario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fun_id", nullable = false)
    private Funcionario funcionario;

    @Column(name = "usu_login", length = 80, nullable = false, unique = true)
    private String login;

    @Column(name = "usu_senha",length = 255, nullable = false)
    private String senha;

    @Column(name = "usu_ultimo_acesso")
    private LocalDateTime ultimoAcesso;

    @Column(name = "usu_trocar_senha")
    private Boolean trocarSenha;

    @Column(name = "usu_ativo")
    private Boolean ativo;

    @Column(name = "usu_dt_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "usu_dt_atualizacao")
    private LocalDateTime dataAtualizacao;

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioRole> roles;
}