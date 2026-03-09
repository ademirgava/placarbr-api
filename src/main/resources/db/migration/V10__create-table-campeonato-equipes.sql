CREATE TABLE campeonato_equipes (
	id BIGINT AUTO_INCREMENT NOT NULL UNIQUE,
	campeonato_id BIGINT NOT NULL,
	equipe_id BIGINT NOT NULL,
	campeonato_fase_id BIGINT NOT NULL,
	PRIMARY KEY (id)
);
ALTER TABLE campeonato_equipes ADD CONSTRAINT campeonato_equipes_fk1 FOREIGN KEY (campeonato_id) REFERENCES campeonatos(id);

ALTER TABLE campeonato_equipes ADD CONSTRAINT campeonato_equipes_fk2 FOREIGN KEY (equipe_id) REFERENCES equipes(id);

ALTER TABLE campeonato_equipes ADD CONSTRAINT campeonato_equipes_fk5 FOREIGN KEY (campeonato_fase_id) REFERENCES campeonato_fases(id);