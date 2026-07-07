CREATE TABLE entrega(
    ent_id INT PRIMARY KEY AUTO_INCREMENT,
    ped_id INT NOT NULL,
    fun_id INT,
    end_id INT,
    ent_taxa DECIMAL(10,2),
    ent_distancia DECIMAL(8,2),
    ent_previsao_minutos INT,
    ent_data_saida DATETIME,
    ent_data_entrega DATETIME,
    ent_status ENUM(
        'AGUARDANDO',
        'SAIU',
        'ENTREGUE',
        'CANCELADA'
    ) DEFAULT 'AGUARDANDO',
    ent_observacao VARCHAR(255),
    FOREIGN KEY(ped_id) REFERENCES pedido(ped_id),
    FOREIGN KEY(fun_id) REFERENCES funcionario(fun_id),
    FOREIGN KEY(end_id) REFERENCES endereco(end_id)
);