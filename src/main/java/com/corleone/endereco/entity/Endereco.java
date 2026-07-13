package com.corleone.endereco.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "end_id")
    private Integer id;

    @Column(name = "end_logradouro", length = 150)
    private String endLogradouro;

    @Column(name = "end_numero", nullable = false)
    private Integer endNumero;

    @Column(name = "end_complemento", length = 100)
    private String endComplemento;

    @Column(name = "end_bairro", length = 50, nullable = false)
    private String endBairro;

    @Column(name = "end_cidade", length = 50, nullable = false)
    private String endCidade;

    @Column(name = "end_estado", length = 2, nullable = false)
    private String endEstado;
}
