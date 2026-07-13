package com.corleone.avaliacao.entity;

import com.corleone.cliente.entity.Cliente;
import com.corleone.pedido.entity.Pedido;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "avaliacao")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ava_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ped_id", nullable = false)
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cli_id", nullable = false)
    private Cliente cliente;

    @Column(name = "ava_nota", nullable = false)
    private Integer nota;

    @Column(name = "ava_comentario", columnDefinition = "TEXT")
    private String comentario;

    @Column(name = "ava_dt_criacao")
    private LocalDateTime dataCriacao;
}