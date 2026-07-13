package com.corleone.pedido.entity;

import com.corleone.borda.entity.Borda;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pedido_borda")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoBorda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pdb_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ipd_id", nullable = false)
    private ItemPedido itemPedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bor_id", nullable = false)
    private Borda borda;
}