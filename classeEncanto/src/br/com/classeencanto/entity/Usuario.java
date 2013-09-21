package br.com.classeencanto.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import br.com.classeencanto.model.impl.AbstractModel;

@Entity
public class Usuario extends AbstractModel {

	@NotNull
	// (message="{usuario.login.vazio}")
	// @Size(max = 15, message="{usuario.login.limite.maximo}")
	// TODO FAZER MIN SIZE
	private String login;

	@NotNull//(message="{usuario.login.vazio}")
	// @Size(max = 15, message="{usuario.login.limite.maximo}")
	// TODO FAZER MIN SIZE
	private String senha;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
