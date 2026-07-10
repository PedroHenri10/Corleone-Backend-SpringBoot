package com.corleone.pedido.entity;

import com.corleone.produto.entity.Produto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "item_pedido")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ipd_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ped_id", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "pro_id", nullable = false)
    private Produto produto;

    @Column(name = "ipd_quantidade", precision = 10, scale = 3)
    private BigDecimal quantidade;

    @Column(name = "ipd_preco_unitario", precision = 10, scale = 2)
    private BigDecimal precoUnitario;

    @Column(name = "ipd_desconto", precision = 10, scale = 2)
    private BigDecimal desconto;

    @Column(name = "ipd_subtotal", precision = 10, scale = 2)
    private BigDecimal subtotal;

    @Column(name = "ipd_observacao", length = 255)
    private String observacao;
}
