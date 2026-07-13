package com.corleone.pedido.entity;

import com.corleone.funcionario.entity.Funcionario;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "historico_pedido")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistoricoPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hpd_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ped_id", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "fun_id")
    private Funcionario funcionario;

    @Column(name = "hpd_status_anterior", length = 40)
    private String statusAnterior;

    @Column(name = "hpd_status_novo", length = 40)
    private String statusNovo;

    @Column(name = "hpd_observacao", length = 255)
    private String observacao;

    @Column(name = "hpd_data")
    private LocalDateTime data;
}
