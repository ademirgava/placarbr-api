CREATE TABLE IF NOT EXISTS campeonato_fases (
	id BIGINT AUTO_INCREMENT NOT NULL UNIQUE,
	nome varchar(70) NOT NULL,
	descricao varchar(255),
	campeonato_id BIGINT NOT NULL,
	ordem_fase BIGINT,
	tipo_fase varchar(9) NOT NULL,
	classificados BIGINT,
	quantidade_grupos BIGINT,
	quantidade_times BIGINT,
	ida_volta boolean NOT NULL,
	PRIMARY KEY (id)
);

ALTER TABLE campeonato_fases ADD CONSTRAINT campeonato_fases_fk1 FOREIGN KEY (campeonato_id) REFERENCES campeonatos(id);