package com.corleone.pagamento.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pagamento")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fpg_id")
    private Long id;

    @Column(name = "fpg_nome", length = 60)
    private String nome;

    @Column(name = "fpg_requer_troco")
    private Boolean requerTroco;

    @Column(name = "fpg_ativo")
    private Boolean ativo = true;
}
