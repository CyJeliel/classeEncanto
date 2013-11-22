package br.com.classeencanto.dao;

import java.util.List;

import br.com.classeencanto.model.impl.Usuario;

public interface UsuarioDAO extends DAO<Usuario> {

	boolean existe(Usuario usuario);

	Usuario findByLoginSenha(Usuario usuario);

	Usuario findById(Long idUsuario);

	List<Usuario> findAll();

}
