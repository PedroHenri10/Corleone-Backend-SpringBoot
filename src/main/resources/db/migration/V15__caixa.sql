CREATE TABLE caixa(
    cai_id INT PRIMARY KEY AUTO_INCREMENT,
    fun_id INT NOT NULL,
    cai_data_abertura DATETIME NOT NULL,
    cai_data_fechamento DATETIME,
    cai_valor_abertura DECIMAL(10,2) NOT NULL,
    cai_valor_fechamento DECIMAL(10,2),
    cai_valor_sistema DECIMAL(10,2),
    cai_diferenca DECIMAL(10,2),
    cai_status ENUM('ABERTO','FECHADO') DEFAULT 'ABERTO',
    cai_observacao VARCHAR(255),
    FOREIGN KEY(fun_id) REFERENCES funcionario(fun_id)
);

CREATE TABLE lancamento_caixa(
    lca_id INT PRIMARY KEY AUTO_INCREMENT,
    cai_id INT NOT NULL,
    fun_id INT NOT NULL,
    ped_id INT,
    fpg_id INT,
    lca_tipo ENUM('ENTRADA','SAIDA','SANGRIA','SUPRIMENTO') NOT NULL,
    lca_valor DECIMAL(10,2) NOT NULL,
    lca_descricao VARCHAR(255),
    lca_data DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(cai_id) REFERENCES caixa(cai_id),
    FOREIGN KEY(fun_id) REFERENCES funcionario(fun_id),
    FOREIGN KEY(ped_id) REFERENCES pedido(ped_id),
    FOREIGN KEY(fpg_id) REFERENCES pagamento(fpg_id)
);