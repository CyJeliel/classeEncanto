package br.com.classeencanto.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.classeencanto.dao.UsuarioDAO;
import br.com.classeencanto.model.impl.Usuario;

@Controller
@SessionScoped
public class AdminController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	@Autowired
	private UsuarioDAO usuarioDAO;

	@RequestMapping("admin")
	public String login(Usuario usuario) {

		if (usuario.existe(usuarioDAO)) {

			this.usuario = usuario;

			return "redirect:produtoDestaque";

		} else {

			return "login";

		}
	}

	@RequestMapping("logout")
	public String logout() {

		this.usuario = null;

		return "login";
	}

	public boolean isLogado() {

		if (usuario == null) {

			return false;
		}

		return true;
	}
}
