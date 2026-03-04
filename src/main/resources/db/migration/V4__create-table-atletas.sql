CREATE TABLE atletas (
	id BIGINT AUTO_INCREMENT NOT NULL UNIQUE,
	cpf varchar(14) NOT NULL,
	rg varchar(12),
	nome varchar(130) NOT NULL,
	email varchar(140) NOT NULL,
	apelido varchar(30),
	data_nascimento date NOT NULL,
	foto LONGBLOB,
	pe_predominante varchar(10) NOT NULL DEFAULT 'Direito',
	descricao varchar(255),
	celular varchar(14) not null,
	endereco_id BIGINT,
	data_criacao DATETIME NOT NULL,
	equipe_id BIGINT,
	PRIMARY KEY (id)
);

ALTER TABLE atletas ADD CONSTRAINT fk_equipe_id_foreign FOREIGN KEY(equipe_id) REFERENCES equipes(id);
ALTER TABLE atletas ADD CONSTRAINT atletas_fk7 FOREIGN KEY (endereco_id) REFERENCES enderecos(id);