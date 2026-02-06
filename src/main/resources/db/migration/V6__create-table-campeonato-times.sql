CREATE TABLE campeonato_times (
	id BIGINT AUTO_INCREMENT NOT NULL UNIQUE,
	campeonato_id BIGINT NOT NULL,
	equipe_id BIGINT NOT NULL,
	PRIMARY KEY (id)
);
ALTER TABLE campeonato_times ADD CONSTRAINT campeonato_times_fk1 FOREIGN KEY (campeonato_id) REFERENCES campeonatos(id);
ALTER TABLE campeonato_times ADD CONSTRAINT campeonato_times_fk2 FOREIGN KEY (equipe_id) REFERENCES equipes(id);