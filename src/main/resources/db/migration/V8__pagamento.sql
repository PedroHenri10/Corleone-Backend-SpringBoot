create table pagamento (
	fpg_id int primary key auto_increment,
    fpg_nome varchar(60),
    fpg_requer_troco tinyint(1) default 1,
    fpg_ativo tinyint(1) default 1
);