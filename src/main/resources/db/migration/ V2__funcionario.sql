CREATE TABLE funcionario(
    fun_id INT PRIMARY KEY AUTO_INCREMENT,
    fun_nome VARCHAR(150) NOT NULL,
    fun_cpf VARCHAR(14) NOT NULL UNIQUE,
    fun_rg VARCHAR(20),
    fun_data_nascimento DATE,
    fun_telefone VARCHAR(20),
    fun_email VARCHAR(120) UNIQUE,
    fun_salario DECIMAL(10,2),
    fun_data_admissao DATE NOT NULL,
    fun_data_demissao DATE,
    fun_ativo TINYINT(1) DEFAULT 1,
    fun_dt_criacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    fun_dt_atualizacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    car_id INT NOT NULL,
    end_id INT,
    FOREIGN KEY (car_id) REFERENCES cargo(car_id),
    FOREIGN KEY (end_id) REFERENCES endereco(end_id)
);