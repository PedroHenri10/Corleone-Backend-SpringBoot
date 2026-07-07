CREATE TABLE configuracao(
    cfg_id INT PRIMARY KEY AUTO_INCREMENT,
    cfg_chave VARCHAR(80) NOT NULL UNIQUE,
    cfg_valor VARCHAR(255) NOT NULL,
    cfg_descricao VARCHAR(255),
    cfg_dt_criacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    cfg_dt_atualizacao DATETIME DEFAULT CURRENT_TIMESTAMP
);