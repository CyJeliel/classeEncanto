package br.com.classeencanto.model.impl;

import java.io.Serializable;

import org.hibernate.validator.internal.constraintvalidators.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.classeencanto.dao.UsuarioDAO;

@Controller
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String login;

	private String senha;

	private String email;

	@Autowired
	private UsuarioDAO usuarioDAO;

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
	
	@RequestMapping("existe")

	public boolean existe() {

		if (valido()) {

			Usuario usuario = usuarioDAO.find(this);

			if (usuario != null) {

				return true;
			}
		}

		return false;
	}

	public void adicionar() {

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
