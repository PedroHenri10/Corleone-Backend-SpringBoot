package com.corleone.estoque.entity;

import com.corleone.funcionario.entity.Funcionario;
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
@Table(name = "estoque")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "est_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pro_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "fun_id")
    private Funcionario funcionario;

    @Enumerated(EnumType.STRING)
    @Column(name = "est_tipo")
    private TipoMovimentacao tipo;

    @Column(name = "est_quantidade", precision = 10, scale = 3)
    private BigDecimal quantidade;

    @Column(name = "est_valor_unitario", precision = 10, scale = 2)
    private BigDecimal valorUnitario;

    @Column(name = "est_documento")
    private String documento;

    @Column(name = "est_observacao")
    private String observacao;

    @Column(name = "est_dt_movimentacao")
    private LocalDateTime dataMovimentacao;
}