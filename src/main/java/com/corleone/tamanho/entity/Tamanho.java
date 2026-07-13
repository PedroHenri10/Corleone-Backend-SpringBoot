package com.corleone.tamanho.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tamanho")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tamanho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tam_id")
    private Long id;

    @Column(name = "tam_nome", length = 50)
    private String nome;

    @Column(name = "tam_fator_preco", precision = 5, scale = 2)
    private BigDecimal fatorPreco;
}