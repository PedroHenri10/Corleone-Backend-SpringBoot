package com.corleone.usuario.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "role")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_id")
    private Long id;

    @Column(name = "rol_nome", nullable = false, unique = true, length = 60)
    private String nome;

    @Column(name = "rol_descricao", length = 255)
    private String descricao;

    @Column(name = "rol_ativo")
    private Boolean ativo;

    @Column(name = "rol_dt_criacao")
    private LocalDateTime dataCriacao;

    @OneToMany(mappedBy = "role")
    private List<UsuarioRole> usuarios;

    @OneToMany(mappedBy = "role")
    private List<RolePermissao> permissoes;
}