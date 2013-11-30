package br.com.classeencanto.model.impl;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-11-27T18:14:22.820-0200")
@StaticMetamodel(UsuarioProduto.class)
public class UsuarioProduto_ {
	public static volatile SingularAttribute<UsuarioProduto, Long> usuarioId;
	public static volatile SingularAttribute<UsuarioProduto, Long> produtoId;
	public static volatile SingularAttribute<UsuarioProduto, Usuario> usuario;
	public static volatile SingularAttribute<UsuarioProduto, Produto> produto;
	public static volatile SingularAttribute<UsuarioProduto, Integer> quantidade;
}
