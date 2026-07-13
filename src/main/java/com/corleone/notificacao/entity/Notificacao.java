package com.corleone.notificacao.entity;

import com.corleone.shared.enums.TipoNotificacao;
import com.corleone.usuario.entity.Usuario;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "notificacao")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "not_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usu_id", nullable = false)
    private Usuario usuario;

    @Column(name = "not_titulo", length = 150)
    private String titulo;

    @Column(name = "not_mensagem", columnDefinition = "TEXT")
    private String mensagem;

    @Enumerated(EnumType.STRING)
    @Column(name = "not_tipo", nullable = false)
    private TipoNotificacao tipo;

    @Column(name = "not_lida")
    private Boolean lida;

    @CreationTimestamp
    @Column(name = "not_data", nullable = false, updatable = false)
    private LocalDateTime data;

    @OneToMany(mappedBy = "notificacao")
    private List<NotificacaoEnvio> envios;
}