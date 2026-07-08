package com.corleone.cargo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "cargo")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long id;

    @Column(name = "car_nome", nullable = false, length = 80)
    private String nome;

    @Column(name = "car_descricao", length = 255)
    private String descricao;

    @Column(name = "car_salario_base", precision = 10, scale = 2)
    private BigDecimal salarioBase;

    @Column(name = "car_ativo")
    private Boolean ativo;

    @Column(name = "car_dt_criacao", updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "car_dt_atualizacao")
    private LocalDateTime dataAtualizacao;
}
