package com.corleone.caixa.entity;

import com.corleone.funcionario.entity.Funcionario;
import com.corleone.pagamento.entity.Pagamento;
import com.corleone.pedido.entity.Pedido;
import com.corleone.shared.enums.TipoLancamentoCaixa;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "lancamento_caixa")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LancamentoCaixa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lca_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cai_id", nullable = false)
    private Caixa caixa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fun_id", nullable = false)
    private Funcionario funcionario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ped_id")
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fpg_id")
    private Pagamento pagamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "lca_tipo", nullable = false)
    private TipoLancamentoCaixa tipo;

    @Column(name = "lca_valor", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(name = "lca_descricao", length = 255)
    private String descricao;

    @Column(name = "lca_data")
    private LocalDateTime data;
}