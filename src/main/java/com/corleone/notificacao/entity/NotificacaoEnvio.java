package com.corleone.notificacao.entity;

import com.corleone.shared.enums.StatusEnvio;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "notificacao_envio")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificacaoEnvio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "noe_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "not_id", nullable = false)
    private Notificacao notificacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "noe_status", nullable = false)
    private StatusEnvio status;

    @CreationTimestamp
    @Column(name = "noe_data", nullable = false, updatable = false)
    private LocalDateTime data;
}
