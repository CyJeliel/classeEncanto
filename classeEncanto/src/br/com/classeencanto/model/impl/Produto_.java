package br.com.classeencanto.model.impl;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-12-01T20:58:28.059-0200")
@StaticMetamodel(Produto.class)
public class Produto_ {
	public static volatile SingularAttribute<Produto, Long> id;
	public static volatile SingularAttribute<Produto, String> nome;
	public static volatile SingularAttribute<Produto, String> resumo;
	public static volatile SingularAttribute<Produto, String> descricao;
	public static volatile SingularAttribute<Produto, byte[]> imagem;
	public static volatile ListAttribute<Produto, Categoria> categorias;
	public static volatile SetAttribute<Produto, UsuarioProduto> listaDeDesejos;
}
