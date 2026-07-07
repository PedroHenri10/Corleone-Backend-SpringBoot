create table cliente (
	cli_id int primary key auto_increment,
	cli_nome varchar(100) not null,
	cli_tel_1 varchar(20) not null,
	cli_tel_2 varchar(20),
	cli_email varchar(100) not null unique,
	cli_status varchar(50),
    cli_ativo tinyint(1) DEFAULT 1,
    cli_dt_criacao datetime,
    cli_dt_atualizacao datetime,
    cli_end_id int,
    FOREIGN KEY(cli_end_id) references endereco(end_id)
);