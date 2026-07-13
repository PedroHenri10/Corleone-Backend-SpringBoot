package com.corleone.produto.entity;

import com.corleone.tamanho.entity.Tamanho;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "produto_tamanho")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoTamanho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prt_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pro_id", nullable = false)
    private Produto produto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tam_id", nullable = false)
    private Tamanho tamanho;

    @Column(name = "prt_preco", precision = 10, scale = 2)
    private BigDecimal preco;
}