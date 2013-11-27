package br.com.classeencanto.model.impl;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-11-27T18:14:22.791-0200")
@StaticMetamodel(Categoria.class)
public class Categoria_ {
	public static volatile SingularAttribute<Categoria, Long> id;
	public static volatile SingularAttribute<Categoria, String> descricao;
	public static volatile SingularAttribute<Categoria, String> tipo;
	public static volatile ListAttribute<Categoria, Produto> produtos;
}
