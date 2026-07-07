CREATE TABLE ingrediente(
    ing_id INT PRIMARY KEY AUTO_INCREMENT,
    ing_nome VARCHAR(120) NOT NULL,
    ing_descricao VARCHAR(255),
    ing_unidade VARCHAR(20) NOT NULL,
    ing_custo_unitario DECIMAL(10,2),
    ing_estoque_minimo DECIMAL(10,3) DEFAULT 0,
    ing_ativo TINYINT(1) DEFAULT 1,
    ing_dt_criacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    ing_dt_atualizacao DATETIME DEFAULT CURRENT_TIMESTAMP
);