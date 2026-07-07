CREATE TABLE log_sistema(
    log_id INT PRIMARY KEY AUTO_INCREMENT,
    usu_id INT,
    log_tabela VARCHAR(80),
    log_acao ENUM('INSERT','UPDATE','DELETE','LOGIN','LOGOUT'),
    log_registro_id INT,
    log_descricao TEXT,
    log_ip VARCHAR(45),
    log_data DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(usu_id) REFERENCES usuario(usu_id)
);

CREATE TABLE login_historico(
    lgh_id INT PRIMARY KEY AUTO_INCREMENT,
    usu_id INT NOT NULL,
    lgh_ip VARCHAR(45),
    lgh_navegador VARCHAR(255),
    lgh_data DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(usu_id) REFERENCES usuario(usu_id)
);

ALTER TABLE log_sistema
ADD COLUMN log_valor_antigo JSON NULL,
ADD COLUMN log_valor_novo JSON NULL,
ADD COLUMN log_usuario VARCHAR(80);