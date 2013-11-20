package br.com.classeencanto.dao;

import br.com.classeencanto.model.impl.Administrador;
import br.com.classeencanto.model.impl.Usuario;

public interface UsuarioDAO extends DAO<Usuario> {

	boolean existe(Usuario usuario);

	Administrador findAdministrador(Administrador administrador);

	Usuario findByLoginSenha(Usuario usuario);

}
