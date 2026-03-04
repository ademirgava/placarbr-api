CREATE TABLE equipes(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(160) NOT NULL,
    sigla VARCHAR(3) NOT NULL,
    ativo BOOLEAN NOT NULL DEFAULT '1',
    logomarca LONGBLOB,
    data_fundacao DATE,
    data_criacao DATETIME ,
    cor_principal VARCHAR(25) NOT NULL,
    cor_secundaria VARCHAR(25) NOT NULL,
    endereco_id BIGINT
);

ALTER TABLE equipes ADD CONSTRAINT equipes_fk7 FOREIGN KEY (endereco_id) REFERENCES enderecos(id);