package br.com.classeencanto.dao;

import br.com.classeencanto.model.impl.Usuario;

public interface UsuarioDAO extends DAO<Usuario> {

	boolean existe(Usuario usuario);

	Usuario findByLoginSenha(Usuario usuario);

}
