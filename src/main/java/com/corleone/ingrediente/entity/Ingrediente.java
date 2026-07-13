package com.corleone.ingrediente.entity;

import com.corleone.produto.entity.ProdutoIngrediente;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ingrediente")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ing_id")
    private Integer id;

    @Column(name = "ing_nome", nullable = false, length = 120)
    private String nome;

    @Column(name = "ing_descricao", length = 255)
    private String descricao;

    @Column(name = "ing_unidade", nullable = false, length = 20)
    private String unidade;

    @Column(name = "ing_custo_unitario", precision = 10, scale = 2)
    private BigDecimal custoUnitario;

    @Column(name = "ing_estoque_minimo", precision = 10, scale = 3)
    private BigDecimal estoqueMinimo;

    @Column(name = "ing_ativo")
    private Boolean ativo;

    @Column(name = "ing_dt_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "ing_dt_atualizacao")
    private LocalDateTime dataAtualizacao;

    @OneToMany(mappedBy = "ingrediente")
    private List<ProdutoIngrediente> produtos;
}