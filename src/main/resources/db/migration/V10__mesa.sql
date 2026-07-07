CREATE TABLE mesa(
    mes_id INT PRIMARY KEY AUTO_INCREMENT,
    mes_numero INT NOT NULL UNIQUE,
    mes_capacidade INT,
    mes_status ENUM(
        'LIVRE',
        'OCUPADA',
        'RESERVADA',
        'MANUTENCAO'
    ) DEFAULT 'LIVRE',
	mes_ativo TINYINT(1) DEFAULT 1,
    mes_dt_criacao DATETIME DEFAULT CURRENT_TIMESTAMP
);