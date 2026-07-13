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
@Table(name = "permissao")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Permissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "per_id")
    private Long id;

    @Column(name = "per_nome", nullable = false, unique = true, length = 100)
    private String nome;

    @Column(name = "per_descricao")
    private String descricao;

    @Column(name = "per_modulo", length = 60)
    private String modulo;

    @Column(name = "per_ativo")
    private Boolean ativo;

    @Column(name = "per_dt_criacao")
    private LocalDateTime dataCriacao;

    @OneToMany(mappedBy = "permissao")
    private List<RolePermissao> roles;
}
