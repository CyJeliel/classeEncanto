CREATE TABLE produto
(
  id serial NOT NULL,
  nome character varying(20) NOT NULL,
  resumo character varying(50) NOT NULL,
  descricao character varying(50) NOT NULL,
  imagem bytea NOT NULL,
  CONSTRAINT produto_pkey PRIMARY KEY (id)
);

CREATE TABLE usuario (
	id			SERIAL			PRIMARY KEY				,
	login		VARCHAR(20)						NOT NULL,
	senha		VARCHAR(20)						NOT NULL,
	email		VARCHAR(20)						NOT NULL
);

