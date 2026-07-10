package com.corleone.cliente.entity;

import com.corleone.endereco.entity.Endereco;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cli_id")
    private Long id;

    @Column(name = "cli_nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "cli_tel_1", nullable = false, length = 20)
    private String telefone1;

    @Column(name = "cli_tel_2", length = 20)
    private String telefone2;

    @Column(name = "cli_email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "cli_status", length = 50)
    private String status;

    @Column(name = "cli_ativo")
    private Boolean ativo;

    @Column(name = "cli_dt_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "cli_dt_atualizacao")
    private LocalDateTime dataAtualizacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cli_end_id")
    private Endereco endereco;
}