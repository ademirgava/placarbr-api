CREATE TABLE campeonato_jogadores (
	id BIGINT AUTO_INCREMENT NOT NULL UNIQUE,
	atleta_id BIGINT NOT NULL,
	posicao varchar(3) NOT NULL,
	campeonato_time_id BIGINT NOT NULL,
	PRIMARY KEY (id)
);

ALTER TABLE campeonato_jogadores ADD CONSTRAINT campeonato_jogadores_fk3 FOREIGN KEY (campeonato_time_id) REFERENCES campeonato_times(id);