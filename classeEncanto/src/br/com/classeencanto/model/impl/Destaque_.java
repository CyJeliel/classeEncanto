package br.com.classeencanto.model.impl;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-12-01T20:58:28.053-0200")
@StaticMetamodel(Destaque.class)
public class Destaque_ {
	public static volatile SingularAttribute<Destaque, Long> id;
	public static volatile SingularAttribute<Destaque, Integer> posicao;
	public static volatile SingularAttribute<Destaque, Produto> produto;
}
