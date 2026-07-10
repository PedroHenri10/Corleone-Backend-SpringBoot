package com.corleone.pedido.entity;

import com.corleone.cliente.entity.Cliente;
import com.corleone.cupom.entity.Cupom;
import com.corleone.funcionario.entity.Funcionario;
import com.corleone.mesa.entity.Mesa;
import com.corleone.pagamento.entity.Pagamento;
import com.corleone.shared.enums.StatusPedido;
import com.corleone.shared.enums.TipoPedido;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pedido")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ped_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cli_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "fun_id", nullable = false)
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "mes_id")
    private Mesa mesa;

    @ManyToOne
    @JoinColumn(name = "cup_id")
    private Cupom cupom;

    @ManyToOne
    @JoinColumn(name = "fpg_id")
    private Pagamento pagamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "ped_tipo")
    private TipoPedido tipo;

    @Column(name = "ped_subtotal", precision = 10, scale = 2)
    private BigDecimal subtotal;

    @Column(name = "ped_desconto", precision = 10, scale = 2)
    private BigDecimal desconto;

    @Column(name = "ped_taxa_entrega", precision = 10, scale = 2)
    private BigDecimal taxaEntrega;

    @Column(name = "ped_total", precision = 10, scale = 2)
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    @Column(name = "ped_status")
    private StatusPedido status;

    @Column(name = "ped_observacao", columnDefinition = "TEXT")
    private String observacao;

    @Column(name = "ped_dt_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "ped_dt_atualizacao")
    private LocalDateTime dataAtualizacao;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens;

    @OneToMany(mappedBy = "pedido")
    private List<HistoricoPedido> historicos;
}