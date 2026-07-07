CREATE TABLE cargo(
    car_id INT PRIMARY KEY AUTO_INCREMENT,
    car_nome VARCHAR(80) NOT NULL,
    car_descricao VARCHAR(255),
    car_salario_base DECIMAL(10,2),
    car_ativo TINYINT(1) DEFAULT 1,
    car_dt_criacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    car_dt_atualizacao DATETIME DEFAULT CURRENT_TIMESTAMP
);

create table endereco (
	end_id int primary key auto_increment,
    end_logradouro varchar(150),
    end_numero int not null,
    end_complemento varchar(100),
    end_bairro varchar(50) not null,
    end_cidade varchar(50) not null,
    end_estado varchar(2) not null
);