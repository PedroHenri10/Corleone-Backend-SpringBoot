package com.corleone.caixa.entity;

import com.corleone.funcionario.entity.Funcionario;
import com.corleone.shared.enums.StatusCaixa;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "caixa")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Caixa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cai_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fun_id", nullable = false)
    private Funcionario funcionario;

    @Column(name = "cai_data_abertura", nullable = false)
    private LocalDateTime dataAbertura;

    @Column(name = "cai_data_fechamento")
    private LocalDateTime dataFechamento;

    @Column(name = "cai_valor_abertura", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorAbertura;

    @Column(name = "cai_valor_fechamento", precision = 10, scale = 2)
    private BigDecimal valorFechamento;

    @Column(name = "cai_valor_sistema", precision = 10, scale = 2)
    private BigDecimal valorSistema;

    @Column(name = "cai_diferenca", precision = 10, scale = 2)
    private BigDecimal diferenca;

    @Enumerated(EnumType.STRING)
    @Column(name = "cai_status", nullable = false)
    private StatusCaixa status = StatusCaixa.ABERTO;

    @Column(name = "cai_observacao", length = 255)
    private String observacao;

    @OneToMany(mappedBy = "caixa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LancamentoCaixa> lancamentos;
}