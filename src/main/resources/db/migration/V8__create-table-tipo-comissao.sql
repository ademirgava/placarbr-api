CREATE TABLE comissao_tecnica_tipo (
	id BIGINT AUTO_INCREMENT NOT NULL UNIQUE,
	nome varchar(100) NOT NULL,
	descricao varchar(255),
	data_criacao DATETIME NOT NULL,
	PRIMARY KEY (id)
);
