package com.corleone.estoque.entity;

import com.corleone.funcionario.entity.Funcionario;
import com.corleone.ingrediente.entity.Ingrediente;
import com.corleone.shared.enums.TipoMovimentacao;
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
@Table(name = "movimento_ingrediente")
public class MovimentoIngrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mgi_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ing_id")
    private Ingrediente ingrediente;

    @ManyToOne
    @JoinColumn(name = "fun_id")
    private Funcionario funcionario;

    @Enumerated(EnumType.STRING)
    @Column(name = "mgi_tipo")
    private TipoMovimentacao tipo;

    @Column(name = "mgi_quantidade", precision = 10, scale = 3)
    private BigDecimal quantidade;

    @Column(name = "mgi_valor_unitario", precision = 10, scale = 2)
    private BigDecimal valorUnitario;

    @Column(name = "mgi_documento")
    private String documento;

    @Column(name = "mgi_observacao")
    private String observacao;

    @Column(name = "mgi_dt_movimentacao")
    private LocalDateTime dataMovimentacao;
}