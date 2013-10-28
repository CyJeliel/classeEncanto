package br.com.classeencanto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.classeencanto.dao.UsuarioDAO;
import br.com.classeencanto.model.impl.Usuario;

@Controller
public class LoginController extends AbstractLoginController {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@RequestMapping({ "/paginaDelogin" })
	public String execute() {
		return "loginAdmin";
	}

	@RequestMapping("login")
	public String login(Usuario usuario) {

		String login = super.login(usuario, usuarioDAO);
		return login;
	}

	@Override
	protected String getPaginaDeLogin() {
		return "redirect:produtoDestaque";
	}

	@Override
	protected String getPaginaDeRetorno() {
		return "loginAdmin";
	}

	@RequestMapping("logout")
	public String logout() {

		this.usuario = null;

		return "loginAdmin";
	}
}
