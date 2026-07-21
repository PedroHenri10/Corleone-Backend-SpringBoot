package com.corleone.categoria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private Integer id;

    @Column(name = "cat_nome", length = 100, nullable = false)
    private String catNome;

    @Column(name = "cat_descricao", length = 255)
    private String catDescricao;

    @Column(name = "cat_ativo")
    private Boolean catAtivo = true;

    @Column(name = "cat_dt_criacao", updatable = false)
    private LocalDateTime catDtCriacao;

    @Column(name = "cat_dt_atualizacao")
    private LocalDateTime catDtAtualizacao;
}
