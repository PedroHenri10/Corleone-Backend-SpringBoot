package com.corleone.promocao.entity;

import com.corleone.produto.entity.Produto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "promocao")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Promocao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prm_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pro_id", nullable = false)
    private Produto produto;

    @Column(name = "prm_nome", length = 120)
    private String nome;

    @Column(name = "prm_descricao", length = 255)
    private String descricao;

    @Column(name = "prm_percentual", precision = 5, scale = 2)
    private BigDecimal percentual;

    @Column(name = "prm_data_inicio")
    private LocalDateTime dataInicio;

    @Column(name = "prm_data_fim")
    private LocalDateTime dataFim;

    @Column(name = "prm_ativa")
    private Boolean ativa;
}