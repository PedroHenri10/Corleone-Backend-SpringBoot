package com.corleone.produto.entity;

import com.corleone.sabor.entity.Sabor;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "produto_sabor",
        uniqueConstraints = @UniqueConstraint(columnNames = {"pro_id", "sab_id"})
)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoSabor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prs_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pro_id", nullable = false)
    private Produto produto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sab_id", nullable = false)
    private Sabor sabor;
}
