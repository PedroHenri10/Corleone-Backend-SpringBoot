CREATE TABLE pedido(
    ped_id INT PRIMARY KEY AUTO_INCREMENT,
    cli_id INT,
    fun_id INT NOT NULL,
    mes_id INT,
    cup_id INT,
    fpg_id INT,
    ped_tipo ENUM(
        'MESA',
        'BALCAO',
        'ENTREGA'
    ) NOT NULL,
    ped_subtotal DECIMAL(10,2) DEFAULT 0,
    ped_desconto DECIMAL(10,2) DEFAULT 0,
    ped_taxa_entrega DECIMAL(10,2) DEFAULT 0,
    ped_total DECIMAL(10,2) DEFAULT 0,
    ped_status ENUM(
        'ABERTO',
        'EM_PREPARO',
        'PRONTO',
        'EM_ENTREGA',
        'FINALIZADO',
        'CANCELADO'
    ) DEFAULT 'ABERTO',
    ped_observacao TEXT,
    ped_dt_criacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    ped_dt_atualizacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(cli_id) REFERENCES cliente(cli_id),
    FOREIGN KEY(fun_id) REFERENCES funcionario(fun_id),
    FOREIGN KEY(mes_id) REFERENCES mesa(mes_id),
    FOREIGN KEY(cup_id) REFERENCES cupom(cup_id),
    FOREIGN KEY(fpg_id) REFERENCES pagamento(fpg_id)
);

CREATE TABLE item_pedido(
    ipd_id INT PRIMARY KEY AUTO_INCREMENT,
    ped_id INT NOT NULL,
    pro_id INT NOT NULL,
    ipd_quantidade DECIMAL(10,3) NOT NULL,
    ipd_preco_unitario DECIMAL(10,2) NOT NULL,
    ipd_desconto DECIMAL(10,2) DEFAULT 0,
    ipd_subtotal DECIMAL(10,2) NOT NULL,
    ipd_observacao VARCHAR(255),
    FOREIGN KEY(ped_id) REFERENCES pedido(ped_id),
    FOREIGN KEY(pro_id) REFERENCES produto(pro_id)
);

CREATE TABLE historico_pedido(
    hpd_id INT PRIMARY KEY AUTO_INCREMENT,
    ped_id INT NOT NULL,
    fun_id INT,
    hpd_status_anterior VARCHAR(40),
    hpd_status_novo VARCHAR(40),
    hpd_observacao VARCHAR(255),
    hpd_data DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(ped_id) REFERENCES pedido(ped_id),
    FOREIGN KEY(fun_id) REFERENCES funcionario(fun_id)
);