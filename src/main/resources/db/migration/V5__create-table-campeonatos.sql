CREATE TABLE campeonatos (
	id BIGINT AUTO_INCREMENT NOT NULL UNIQUE,
	nome varchar(120) NOT NULL,
	descricao varchar(255) NOT NULL,
	data_inicio date,
	data_criacao datetime NOT NULL,
    iniciado BOOLEAN NOT NULL DEFAULT '1',
	PRIMARY KEY (id)
);