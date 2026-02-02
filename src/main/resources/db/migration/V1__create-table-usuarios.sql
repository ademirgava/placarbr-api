CREATE TABLE usuarios( 
    id bigint not null auto_increment PRIMARY KEY,
    login varchar(120) not null unique,
    senha varchar(255) not null,
	nome varchar(150) not null,
	data_nascimento DATE 
);

insert into placarbr.usuarios values(1, 'juninhogava', '$2a$12$8x1iEwhWWFSxlqSIlzVR.eLmzer0Cpj.dr.5s52UcpM4UoS49ywO2', 'Ademir Gava Jr', '1984-10-25');