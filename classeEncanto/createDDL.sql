CREATE TABLE produto
(
  id        serial                 NOT NULL,
  nome      character varying(100) NOT NULL,
  resumo    character varying(200) NOT NULL,
  descricao character varying(300) NOT NULL,
  imagem    bytea                  NOT NULL,

  CONSTRAINT produto_pkey PRIMARY KEY (id)
);

CREATE TABLE categoria
(
  id serial NOT NULL,
  descricao character varying(50) NOT NULL,
  tipo character varying(30) NOT NULL,
  CONSTRAINT evento_pkey PRIMARY KEY (id)
);

CREATE TABLE produto_categoria
(
  produto_id   bigint NOT NULL,
  categoria_id bigint NOT NULL,

  CONSTRAINT produto_categoria_pk PRIMARY KEY (produto_id, categoria_id),

  CONSTRAINT produto_categoria_categoria_id_fkey FOREIGN KEY (categoria_id)
      REFERENCES categoria (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,

  CONSTRAINT produto_categoria_produto_id_fkey FOREIGN KEY (produto_id)
      REFERENCES produto (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE usuario (
	id			SERIAL							NOT NULL,
	login		VARCHAR(20)						NOT NULL,
	senha		VARCHAR(20)						NOT NULL,
	email		VARCHAR(100)					NOT NULL,
    admin	    boolean                         NOT NULL DEFAULT false,
    CONSTRAINT usuario_pkey      PRIMARY KEY (id),
    CONSTRAINT usuario_email_key UNIQUE      (email),
    CONSTRAINT usuario_login_key UNIQUE      (login)

);

CREATE TABLE lista_de_desejos (
  usuario_id bigint NOT NULL,
  produto_id bigint NOT NULL,
  quantidade int NOT NULL,
  CONSTRAINT lista_de_desejos_pkey PRIMARY KEY (usuario_id, produto_id),
  CONSTRAINT produto_fk FOREIGN KEY (produto_id)
      REFERENCES produto (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT usuario_fk FOREIGN KEY (usuario_id)
      REFERENCES usuario (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)

CREATE TABLE destaque (
	id			SERIAL							NOT NULL,
	posicao     int                             NOT NULL,
	produto_id  bigint							NOT NULL,
	CONSTRAINT destaque_pkey PRIMARY KEY (id),
  	CONSTRAINT produto_fk FOREIGN KEY (produto_id)
      REFERENCES produto (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
