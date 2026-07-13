package com.corleone.auditoria.entity;

import com.corleone.shared.enums.AcaoLog;
import com.corleone.usuario.entity.Usuario;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Entity
@Table(name = "log_sistema")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogSistema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usu_id")
    private Usuario usuario;

    @Column(name = "log_tabela", length = 80)
    private String tabela;

    @Enumerated(EnumType.STRING)
    @Column(name = "log_acao", nullable = false)
    private AcaoLog acao;

    @Column(name = "log_registro_id")
    private Long registroId;

    @Column(name = "log_descricao", columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "log_ip", length = 45)
    private String ip;

    @Column(name = "log_usuario", length = 80)
    private String nomeUsuario;

    @Column(name = "log_valor_antigo", columnDefinition = "json")
    private String valorAntigo;

    @Column(name = "log_valor_novo", columnDefinition = "json")
    private String valorNovo;

    @CreationTimestamp
    @Column(name = "log_data", updatable = false)
    private LocalDateTime data;
}