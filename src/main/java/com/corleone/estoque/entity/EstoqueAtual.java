package com.corleone.estoque.entity;

import com.corleone.produto.entity.Produto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "estoque_atual")
public class EstoqueAtual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eat_id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "pro_id")
    private Produto produto;

    @Column(name = "eat_quantidade", precision = 10, scale = 3)
    private BigDecimal quantidade;

    @Column(name = "eat_dt_atualizacao")
    private LocalDateTime dataAtualizacao;
}
