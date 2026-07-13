package com.corleone.auditoria.entity;

import com.corleone.usuario.entity.Usuario;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "login_historico")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginHistorico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lgh_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usu_id", nullable = false)
    private Usuario usuario;

    @Column(name = "lgh_ip", length = 45)
    private String ip;

    @Column(name = "lgh_navegador", length = 255)
    private String navegador;

    @CreationTimestamp
    @Column(name = "lgh_data", updatable = false)
    private LocalDateTime data;
}
