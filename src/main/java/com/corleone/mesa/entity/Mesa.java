package com.corleone.mesa.entity;

import com.corleone.mesa.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "mesa")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mes_id")
    private Long id;

    @Column(name = "mes_numero", nullable = false, unique = true)
    private Integer numero;

    @Column(name = "mes_capacidade")
    private Integer capacidade;

    @Enumerated(EnumType.STRING)
    @Column(name = "mes_status")
    @Builder.Default
    private Status status = Status.LIVRE;

    @Column(name = "mes_ativo")
    private Boolean ativo = true;

    @Column(name = "mes_dt_criacao")
    private LocalDateTime dataCriacao;
}
