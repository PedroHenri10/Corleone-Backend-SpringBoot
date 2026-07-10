package com.corleone.entrega.entity;

import com.corleone.endereco.entity.Endereco;
import com.corleone.funcionario.entity.Funcionario;
import com.corleone.pedido.entity.Pedido;
import com.corleone.shared.enums.StatusEntrega;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "entrega")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ent_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "ped_id", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "fun_id")
    private Funcionario entregador;

    @ManyToOne
    @JoinColumn(name = "end_id")
    private Endereco endereco;

    @Column(name = "ent_taxa", precision = 10, scale = 2)
    private BigDecimal taxa;

    @Column(name = "ent_distancia", precision = 8, scale = 2)
    private BigDecimal distancia;

    @Column(name = "ent_previsao_minutos")
    private Integer previsaoMinutos;

    @Column(name = "ent_data_saida")
    private LocalDateTime dataSaida;

    @Column(name = "ent_data_entrega")
    private LocalDateTime dataEntrega;

    @Enumerated(EnumType.STRING)
    @Column(name = "ent_status")
    private StatusEntrega status;

    @Column(name = "ent_observacao", length = 255)
    private String observacao;
}
