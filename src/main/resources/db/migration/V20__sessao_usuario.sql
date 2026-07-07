CREATE TABLE sessao_usuario(
    ses_id INT PRIMARY KEY AUTO_INCREMENT,
    usu_id INT NOT NULL,
    ses_token VARCHAR(500),
    ses_ip VARCHAR(45),
    ses_inicio DATETIME,
    ses_fim DATETIME,
    ses_ativa TINYINT(1) DEFAULT 1,
    FOREIGN KEY(usu_id) REFERENCES usuario(usu_id)
);