CREATE TABLE estoque_atual(
    eat_id INT PRIMARY KEY AUTO_INCREMENT,
    pro_id INT NOT NULL,
    eat_quantidade DECIMAL(10,3) NOT NULL DEFAULT 0,
    eat_dt_atualizacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(pro_id) REFERENCES produto(pro_id),
    UNIQUE(pro_id)
);

CREATE TABLE estoque(
    est_id INT PRIMARY KEY AUTO_INCREMENT,
    pro_id INT NOT NULL,
    fun_id INT NOT NULL,
    est_tipo ENUM(
        'ENTRADA',
        'SAIDA',
        'AJUSTE'
    ) NOT NULL,
    est_quantidade DECIMAL(10,3) NOT NULL,
    est_valor_unitario DECIMAL(10,2),
    est_documento VARCHAR(50),
    est_observacao VARCHAR(255),
    est_dt_movimentacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(pro_id) REFERENCES produto(pro_id),
    FOREIGN KEY(fun_id) REFERENCES funcionario(fun_id)
);

CREATE TABLE estoque_ingrediente(
    eti_id INT PRIMARY KEY AUTO_INCREMENT,
    ing_id INT NOT NULL,
    eti_quantidade DECIMAL(10,3) NOT NULL DEFAULT 0,
    eti_dt_atualizacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(ing_id) REFERENCES ingrediente(ing_id),
    UNIQUE(ing_id)
);

CREATE TABLE movimento_ingrediente(
    mgi_id INT PRIMARY KEY AUTO_INCREMENT,
    ing_id INT NOT NULL,
    fun_id INT NOT NULL,
    mgi_tipo ENUM(
        'ENTRADA',
        'SAIDA',
        'AJUSTE'
    ) NOT NULL,
    mgi_quantidade DECIMAL(10,3) NOT NULL,
    mgi_valor_unitario DECIMAL(10,2),
    mgi_documento VARCHAR(50),
    mgi_observacao VARCHAR(255),
    mgi_dt_movimentacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(ing_id) REFERENCES ingrediente(ing_id),
    FOREIGN KEY(fun_id) REFERENCES funcionario(fun_id)
);