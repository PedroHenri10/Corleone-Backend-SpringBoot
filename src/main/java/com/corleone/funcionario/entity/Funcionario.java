package com.corleone.funcionario.entity;

import com.corleone.cargo.entity.Cargo;
import com.corleone.endereco.entity.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fun_id")
    private Integer funId;

    @Column(name = "fun_nome", length = 150, nullable = false)
    private String funNome;

    @Column(name = "fun_cpf", length = 14, nullable = false, unique = true)
    private String funCpf;

    @Column(name = "fun_rg", length = 2)
    private String funRg;

    @Column(name = "fun_data_nascimento")
    private LocalDate funDataNascimento;

    @Column(name = "fun_telefone", length = 20)
    private String funTelefone;

    @Column(name = "fun_email", length = 120, unique = true)
    private String funEmail;

    @Column(name = "fun_salario", precision = 10, scale = 2)
    private BigDecimal funSalario;

    @Column(name = "fun_data_admissao", nullable = false)
    private LocalDate funDataAdmissao;

    @Column(name = "fun_data_demissao")
    private LocalDate funDataDemissao;

    @Column(name = "fun_ativo")
    private Boolean funAtivo = true;

    @Column(name = "fun_dt_criacao", updatable = false)
    private LocalDateTime funDtCriacao = LocalDateTime.now();

    @Column(name = "fun_dt_atualizacao")
    private LocalDateTime funDtAtualizacao = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "end_id")
    private Endereco endereco;
}
