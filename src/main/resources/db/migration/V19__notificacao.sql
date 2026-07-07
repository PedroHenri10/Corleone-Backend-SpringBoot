CREATE TABLE notificacao(
    not_id INT PRIMARY KEY AUTO_INCREMENT,
    usu_id INT NOT NULL,
    not_titulo VARCHAR(150),
    not_mensagem TEXT,
    not_tipo ENUM(
        'PEDIDO',
        'ESTOQUE',
        'CAIXA',
        'PROMOCAO',
        'SISTEMA'
    ),
    not_lida TINYINT(1) DEFAULT 0,
    not_data DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(usu_id) REFERENCES usuario(usu_id)
);

CREATE TABLE notificacao_envio(
    noe_id INT PRIMARY KEY AUTO_INCREMENT,
    not_id INT NOT NULL,
    noe_status ENUM(
        'PENDENTE',
        'ENVIADA',
        'ERRO'
    ),
    noe_data DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(not_id) REFERENCES notificacao(not_id)
);