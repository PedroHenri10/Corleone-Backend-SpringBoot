package com.corleone.produto.entity;

import com.corleone.categoria.entity.Categoria;
import com.corleone.fornecedor.entity.Fornecedor;
import com.corleone.promocao.entity.Promocao;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "produto")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pro_fornecedor_for_id", nullable = false)
    private Fornecedor fornecedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cat_id", nullable = false)
    private Categoria categoria;

    @Column(name = "pro_cod", nullable = false, unique = true, length = 30)
    private String codigo;

    @Column(name = "pro_nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "pro_descricao", columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "pro_preco_custo", nullable = false, precision = 10, scale = 2)
    private BigDecimal precoCusto;

    @Column(name = "pro_preco_venda", nullable = false, precision = 10, scale = 2)
    private BigDecimal precoVenda;

    @Column(name = "pro_estoque_minimo", precision = 10, scale = 3)
    private BigDecimal estoqueMinimo;

    @Column(name = "pro_ativo")
    private Boolean ativo;

    @Column(name = "pro_dt_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "pro_dt_atualizacao")
    private LocalDateTime dataAtualizacao;

    @OneToMany(mappedBy = "produto")
    private List<Promocao> promocoes;

    @OneToMany(mappedBy = "produto")
    private List<ProdutoIngrediente> ingredientes;
}