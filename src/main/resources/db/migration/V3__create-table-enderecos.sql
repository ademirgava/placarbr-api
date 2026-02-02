CREATE TABLE enderecos (
	id int AUTO_INCREMENT NOT NULL UNIQUE,
	logradouro varchar(255) NOT NULL,
	numero varchar(10) NOT NULL,
	bairro varchar(125) NOT NULL,
	cidade varchar(125) NOT NULL,
	cep varchar(9) NOT NULL,
	uf varchar(2) NOT NULL,
	complemento varchar(120),
	PRIMARY KEY (id)
);


ALTER TABLE jogadores ADD CONSTRAINT jogadores_fk7 FOREIGN KEY (endereco_id) REFERENCES enderecos(id);