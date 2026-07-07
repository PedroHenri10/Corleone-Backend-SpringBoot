CREATE TABLE produto(
    pro_id INT PRIMARY KEY AUTO_INCREMENT,
    pro_fornecedor_for_id INT NOT NULL,
    cat_id INT NOT NULL,
    pro_cod VARCHAR(30) NOT NULL UNIQUE,
    pro_nome VARCHAR(150) NOT NULL,
    pro_descricao TEXT,
    pro_preco_custo DECIMAL(10,2) NOT NULL,
    pro_preco_venda DECIMAL(10,2) NOT NULL,
    pro_estoque_minimo DECIMAL(10,3) DEFAULT 0,
    pro_ativo TINYINT(1) DEFAULT 1,
    pro_dt_criacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    pro_dt_atualizacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(pro_fornecedor_for_id) REFERENCES fornecedor(for_id),
    FOREIGN KEY(cat_id) REFERENCES categoria(cat_id)
);

CREATE TABLE promocao(
    prm_id INT PRIMARY KEY AUTO_INCREMENT,
    pro_id INT NOT NULL,
    prm_nome VARCHAR(120),
    prm_descricao VARCHAR(255),
    prm_percentual DECIMAL(5,2),
    prm_data_inicio DATETIME,
    prm_data_fim DATETIME,
    prm_ativa TINYINT(1) DEFAULT 1,
    FOREIGN KEY(pro_id) REFERENCES produto(pro_id)
);