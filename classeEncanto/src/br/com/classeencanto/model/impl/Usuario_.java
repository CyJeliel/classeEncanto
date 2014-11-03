package br.com.classeencanto.model.impl;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-11-02T21:38:14.965-0200")
@StaticMetamodel(Usuario.class)
public class Usuario_ {
	public static volatile SingularAttribute<Usuario, Long> id;
	public static volatile SingularAttribute<Usuario, String> login;
	public static volatile SingularAttribute<Usuario, String> senha;
	public static volatile SingularAttribute<Usuario, String> email;
	public static volatile SetAttribute<Usuario, UsuarioProduto> listaDeDesejos;
	public static volatile SingularAttribute<Usuario, Boolean> admin;
}
