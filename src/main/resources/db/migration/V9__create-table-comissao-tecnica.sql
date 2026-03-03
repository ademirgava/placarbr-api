CREATE TABLE comissao_tecnica (
	id BIGINT AUTO_INCREMENT NOT NULL UNIQUE,
	cpf varchar(14) NOT NULL,
	rg varchar(12),
	registro_tipo varchar(60),
	registro varchar(100),
	nome varchar(130) NOT NULL,
	email varchar(140) NOT NULL,
	apelido varchar(30),
	data_nascimento date NOT NULL,
	foto LONGBLOB,
	descricao varchar(255),
	celular varchar(14) not null,
	endereco_id BIGINT,
	data_criacao DATETIME NOT NULL,
	comissao_tecnica_tipo_id BIGINT, 
	PRIMARY KEY (id)
);

ALTER TABLE comissao_tecnica ADD CONSTRAINT comissao_tecnica_fk1 FOREIGN KEY (comissao_tecnica_tipo_id) REFERENCES comissao_tecnica_tipo(id);