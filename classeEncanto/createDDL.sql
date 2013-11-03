CREATE TABLE produto (
	id			SERIAL			PRIMARY KEY				,
	nome		VARCHAR(20)						NOT NULL,
	resumo		VARCHAR(50)						NOT NULL,
	descricao	VARCHAR(50)						NOT NULL
);

CREATE TABLE usuario (
	id			SERIAL			PRIMARY KEY				,
	login		VARCHAR(20)						NOT NULL,
	senha		VARCHAR(20)						NOT NULL,
	email		VARCHAR(20)						NOT NULL
);

