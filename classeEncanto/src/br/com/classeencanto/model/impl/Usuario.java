package br.com.classeencanto.model.impl;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.internal.constraintvalidators.EmailValidator;

import br.com.classeencanto.dao.UsuarioDAO;

@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	private Long id;
	private String login;
	private String senha;
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean valido() {

		if (login == null || login.isEmpty()) {

			return false;
		}

		if (senha == null || senha.isEmpty()) {

			return false;
		}

		return true;
	}

	public boolean existe(UsuarioDAO usuarioDAO) {

		if (valido()) {

			Usuario usuario = usuarioDAO.find(this);

			if (usuario != null) {

				return true;
			}
		}

		return false;
	}

	public void adicionar(UsuarioDAO usuarioDAO) {

		usuarioDAO.save(this);
	}

	public boolean validarInsercao(String confirmacaoSenha) {

		if (valido()) {

			EmailValidator emailValidator = new EmailValidator();

			if (senha.equals(confirmacaoSenha)
					&& emailValidator.isValid(email, null)) {

				return true;
			}
		}

		return false;
	}

}
