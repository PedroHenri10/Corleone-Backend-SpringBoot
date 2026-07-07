CREATE TABLE cargo(
    car_id INT PRIMARY KEY AUTO_INCREMENT,
    car_nome VARCHAR(80) NOT NULL,
    car_descricao VARCHAR(255),
    car_salario_base DECIMAL(10,2),
    car_ativo TINYINT(1) DEFAULT 1,
    car_dt_criacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    car_dt_atualizacao DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE endereco(
    end_id INT PRIMARY KEY AUTO_INCREMENT,
    end_logradouro VARCHAR(150),
    end_numero INT NOT NULL,
    end_complemento VARCHAR(100),
    end_bairro VARCHAR(50) NOT NULL,
    end_cidade VARCHAR(50) NOT NULL,
    end_estado VARCHAR(2) NOT NULL
);