package com.corleone.fornecedor.entity;

import com.corleone.endereco.entity.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fornecedor")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "for_id")
    private Long id;

    @Column(name = "for_nome", length = 150, nullable = false)
    private String forNome;

    @Column(name = "for_nome_fantasia", length = 150)
    private String forNomeFantasia;

    @Column(name = "for_cnpj", length = 18, nullable = false, unique = true)
    private String forCnpj;

    @Column(name = "for_telefone", length = 20, nullable = false)
    private String forTelefone;

    @Column(name = "for_email", length = 100, nullable = false, unique = true)
    private String forEmail;

    @Column(name = "for_contato_responsavel", length = 120)
    private String forContatoResponsavel;

    @Column(name = "for_ativo")
    private Boolean forAtivo = true;

    @Column(name = "for_dt_criacao", updatable = false)
    private LocalDateTime forDtCriacao = LocalDateTime.now();

    @Column(name = "for_dt_atualizacao")
    private LocalDateTime forDtAtualizacao = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "for_end_id")
    private Endereco endereco;
}
