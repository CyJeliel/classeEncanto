package br.com.classeencanto.controller;

import br.com.classeencanto.dao.UsuarioDAO;
import br.com.classeencanto.model.impl.Usuario;

public abstract class AbstractLoginController {
	
	protected Usuario usuario;

	public String login(Usuario usuario, UsuarioDAO usuarioDAO) {

		if (usuario.existe(usuarioDAO)) {

			this.usuario = usuario;

			return getPaginaDeRetorno();

		} else {

			return getPaginaDeLogin();

		}
	}

	abstract protected String getPaginaDeLogin();

	abstract protected String getPaginaDeRetorno();

}
