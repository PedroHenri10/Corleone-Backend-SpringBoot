CREATE TABLE role(
    rol_id INT PRIMARY KEY AUTO_INCREMENT,
    rol_nome VARCHAR(60) NOT NULL UNIQUE,
    rol_descricao VARCHAR(255),
    rol_ativo TINYINT(1) DEFAULT 1,
    rol_dt_criacao DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE permissao(
    per_id INT PRIMARY KEY AUTO_INCREMENT,
    per_nome VARCHAR(100) NOT NULL UNIQUE,
    per_descricao VARCHAR(255),
    per_modulo VARCHAR(60),
    per_ativo TINYINT(1) DEFAULT 1,
    per_dt_criacao DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE usuario(
    usu_id INT PRIMARY KEY AUTO_INCREMENT,
    fun_id INT NOT NULL,
    usu_login VARCHAR(80) NOT NULL UNIQUE,
    usu_senha VARCHAR(255) NOT NULL,
    usu_ultimo_acesso DATETIME,
    usu_trocar_senha TINYINT(1) DEFAULT 0,
    usu_ativo TINYINT(1) DEFAULT 1,
    usu_dt_criacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    usu_dt_atualizacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(fun_id) REFERENCES funcionario(fun_id)
);

CREATE TABLE usuario_role(
    uro_id INT PRIMARY KEY AUTO_INCREMENT,
    usu_id INT NOT NULL,
    rol_id INT NOT NULL,
    uro_dt_criacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(usu_id) REFERENCES usuario(usu_id),
    FOREIGN KEY(rol_id) REFERENCES role(rol_id),
    UNIQUE(usu_id,rol_id)
);

CREATE TABLE role_permissao(
    rpe_id INT PRIMARY KEY AUTO_INCREMENT,
    rol_id INT NOT NULL,
    per_id INT NOT NULL,
    rpe_dt_criacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(rol_id) REFERENCES role(rol_id),
    FOREIGN KEY(per_id) REFERENCES permissao(per_id),
    UNIQUE(rol_id,per_id)
);