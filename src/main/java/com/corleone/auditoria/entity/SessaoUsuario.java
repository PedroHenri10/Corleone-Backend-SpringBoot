package com.corleone.auditoria.entity;

import com.corleone.usuario.entity.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sessao_usuario")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SessaoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ses_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usu_id", nullable = false)
    private Usuario usuario;

    @Column(name = "ses_token", length = 500)
    private String token;

    @Column(name = "ses_ip", length = 45)
    private String ip;

    @Column(name = "ses_inicio")
    private LocalDateTime inicio;

    @Column(name = "ses_fim")
    private LocalDateTime fim;

    @Column(name = "ses_ativa")
    private Boolean ativa;
}
