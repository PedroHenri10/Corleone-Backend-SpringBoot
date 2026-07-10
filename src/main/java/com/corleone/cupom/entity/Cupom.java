package com.corleone.cupom.entity;

import com.corleone.shared.enums.TipoCupom;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "cupom")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cupom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cup_id")
    private Long id;

    @Column(name = "cup_codigo", nullable = false, unique = true, length = 30)
    private String codigo;

    @Column(name = "cup_descricao", length = 255)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "cup_tipo", nullable = false)
    private TipoCupom tipo;

    @Column(name = "cup_valor", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(name = "cup_valor_minimo", precision = 10, scale = 2)
    private BigDecimal valorMinimo;

    @Column(name = "cup_data_inicio")
    private LocalDateTime dataInicio;

    @Column(name = "cup_data_fim")
    private LocalDateTime dataFim;

    @Column(name = "cup_limite_uso")
    private Integer limiteUso;

    @Column(name = "cup_ativo")
    private Boolean ativo = true;

    @Column(name = "cup_dt_criacao")
    private LocalDateTime dataCriacao;
}
