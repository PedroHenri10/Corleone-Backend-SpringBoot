package com.corleone.borda.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "borda")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Borda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bor_id")
    private Long id;

    @Column(name = "bor_nome", length = 80)
    private String nome;

    @Column(name = "bor_preco", precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(name = "bor_ativo")
    private Boolean ativo;
}