CREATE TABLE sabor(
    sab_id INT PRIMARY KEY AUTO_INCREMENT,
    sab_nome VARCHAR(100),
    sab_descricao VARCHAR(255),
    sab_ativo TINYINT(1) DEFAULT 1
);

CREATE TABLE tamanho(
    tam_id INT PRIMARY KEY AUTO_INCREMENT,
    tam_nome VARCHAR(50),
    tam_fator_preco DECIMAL(5,2)
);

CREATE TABLE produto_sabor(
    prs_id INT PRIMARY KEY AUTO_INCREMENT,
    pro_id INT NOT NULL,
    sab_id INT NOT NULL,
    FOREIGN KEY(pro_id) REFERENCES produto(pro_id),
    FOREIGN KEY(sab_id) REFERENCES sabor(sab_id),
    UNIQUE(pro_id,sab_id)
);

CREATE TABLE produto_tamanho(
    prt_id INT PRIMARY KEY AUTO_INCREMENT,
    pro_id INT NOT NULL,
    tam_id INT NOT NULL,
    prt_preco DECIMAL(10,2),
    FOREIGN KEY(pro_id) REFERENCES produto(pro_id),
    FOREIGN KEY(tam_id) REFERENCES tamanho(tam_id)
);

CREATE TABLE borda(
    bor_id INT PRIMARY KEY AUTO_INCREMENT,
    bor_nome VARCHAR(80),
    bor_preco DECIMAL(10,2),
    bor_ativo TINYINT(1) DEFAULT 1
);

CREATE TABLE pedido_borda(
    pdb_id INT PRIMARY KEY AUTO_INCREMENT,
    ipd_id INT NOT NULL,
    bor_id INT NOT NULL,
    FOREIGN KEY(ipd_id) REFERENCES item_pedido(ipd_id),
    FOREIGN KEY(bor_id) REFERENCES borda(bor_id)
);