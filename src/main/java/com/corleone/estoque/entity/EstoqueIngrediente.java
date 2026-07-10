package com.corleone.estoque.entity;

import com.corleone.ingrediente.entity.Ingrediente;
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
@Table(name = "estoque_ingrediente")
public class EstoqueIngrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eti_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "ing_id")
    private Ingrediente ingrediente;

    @Column(name = "eti_quantidade", precision = 10, scale = 3)
    private BigDecimal quantidade;

    @Column(name = "eti_dt_atualizacao")
    private LocalDateTime dataAtualizacao;
}
