package com.corleone.sabor.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sabor")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sabor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sab_id")
    private Integer id;

    @Column(name = "sab_nome",nullable = false, unique = true, length = 100)
    private String nome;

    @Column(name = "sab_descricao", length = 255)
    private String descricao;

    @Column(name = "sab_ativo")
    private Boolean ativo;
}
