package com.corleone.configuracao.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "configuracao")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Configuracao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cfg_id")
    private Long id;

    @Column(name = "cfg_chave", nullable = false, unique = true, length = 80)
    private String chave;

    @Column(name = "cfg_valor", nullable = false, length = 255)
    private String valor;

    @Column(name = "cfg_descricao", length = 255)
    private String descricao;

    @Column(name = "cfg_dt_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "cfg_dt_atualizacao")
    private LocalDateTime dataAtualizacao;
}
