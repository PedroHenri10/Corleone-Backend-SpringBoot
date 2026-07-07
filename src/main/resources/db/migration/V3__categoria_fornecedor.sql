CREATE TABLE categoria(
    cat_id INT PRIMARY KEY AUTO_INCREMENT,
    cat_nome VARCHAR(100) NOT NULL,
    cat_descricao VARCHAR(255),
    cat_ativo TINYINT(1) DEFAULT 1,
    cat_dt_criacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    cat_dt_atualizacao DATETIME DEFAULT CURRENT_TIMESTAMP
);

create table fornecedor(
	for_id int primary key auto_increment,
    for_nome varchar(150) not null,
    for_nome_fantasia varchar(150),
    for_cnpj varchar(18) not null unique,
    for_telefone varchar(20) not null,
    for_email varchar(100) unique not null,
    for_contato_responsavel varchar(120),
    for_ativo tinyint(1) DEFAULT 1,
    for_dt_criacao datetime,
    for_dt_atualizacao datetime,
    for_end_id int,
    foreign key(for_end_id) references endereco(end_id)
);