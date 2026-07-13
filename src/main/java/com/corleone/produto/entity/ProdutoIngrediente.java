package com.corleone.produto.entity;

import com.corleone.ingrediente.entity.Ingrediente;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "produto_ingrediente",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_produto_ingrediente",
                        columnNames = {"pro_id", "ing_id"}
                )
        }
)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoIngrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pin_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pro_id", nullable = false)
    private Produto produto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ing_id", nullable = false)
    private Ingrediente ingrediente;

    @Column(name = "pin_quantidade", nullable = false, precision = 10, scale = 3)
    private BigDecimal quantidade;

    @Column(name = "pin_unidade", length = 20)
    private String unidade;

    @Column(name = "pin_dt_criacao")
    private LocalDateTime dataCriacao;
}