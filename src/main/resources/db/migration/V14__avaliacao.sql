CREATE TABLE avaliacao(
    ava_id INT PRIMARY KEY AUTO_INCREMENT,
    ped_id INT NOT NULL,
    cli_id INT NOT NULL,
    ava_nota INT NOT NULL,
    ava_comentario TEXT,
    ava_dt_criacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(ped_id) REFERENCES pedido(ped_id),
    FOREIGN KEY(cli_id) REFERENCES cliente(cli_id)
);