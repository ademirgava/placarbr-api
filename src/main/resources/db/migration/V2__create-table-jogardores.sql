CREATE TABLE jogadores (
	id BIGINT AUTO_INCREMENT NOT NULL UNIQUE,
	cpf varchar(14) NOT NULL,
	rg varchar(12),
	nome varchar(130) NOT NULL,
	apelido varchar(30),
	data_nascimento date NOT NULL,
	foto blob,
	pe_predominante varchar(10) NOT NULL DEFAULT 'Direito',
	descricao varchar(255),
	celular varchar(14) not null,
	endereco_id BIGINT,
	data_criacao DATETIME NOT NULL,
	PRIMARY KEY (id)
);
