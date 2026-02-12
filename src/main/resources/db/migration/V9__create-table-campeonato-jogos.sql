CREATE TABLE campeonato_jogos (
	id BIGINT AUTO_INCREMENT NOT NULL UNIQUE,
	campeonato_id BIGINT NOT NULL,
	time_mandante_id BIGINT NOT NULL,
	time_visitante_id BIGINT NOT NULL,
	rodada BIGINT NOT NULL,
	campeonato_fase_id BIGINT NOT NULL,
	PRIMARY KEY (id)
);
ALTER TABLE campeonato_jogos ADD CONSTRAINT campeonato_jogos_fk1 FOREIGN KEY (campeonato_id) REFERENCES campeonatos(id);

ALTER TABLE campeonato_jogos ADD CONSTRAINT campeonato_jogos_fk2 FOREIGN KEY (time_mandante_id) REFERENCES campeonato_times(id);

ALTER TABLE campeonato_jogos ADD CONSTRAINT campeonato_jogos_fk3 FOREIGN KEY (time_visitante_id) REFERENCES campeonato_times(id);

ALTER TABLE campeonato_jogos ADD CONSTRAINT campeonato_jogos_fk5 FOREIGN KEY (campeonato_fase_id) REFERENCES campeonato_fases(id);