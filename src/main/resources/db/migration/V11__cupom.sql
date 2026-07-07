CREATE TABLE cupom(
    cup_id INT PRIMARY KEY AUTO_INCREMENT,
    cup_codigo VARCHAR(30) UNIQUE NOT NULL,
    cup_descricao VARCHAR(255),
    cup_tipo ENUM(
        'PERCENTUAL',
        'VALOR'
    ) NOT NULL,
    cup_valor DECIMAL(10,2) NOT NULL,
    cup_valor_minimo DECIMAL(10,2),
    cup_data_inicio DATETIME,
    cup_data_fim DATETIME,
    cup_limite_uso INT,
    cup_ativo TINYINT(1) DEFAULT 1,
    cup_dt_criacao DATETIME DEFAULT CURRENT_TIMESTAMP
);