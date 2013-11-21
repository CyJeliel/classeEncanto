package br.com.classeencanto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.classeencanto.dao.UsuarioDAO;
import br.com.classeencanto.model.impl.Usuario;

@Controller
public class LoginController extends AbstractLoginController {

	@Autowired
	private AdminController adminController;

	@Autowired
	private UsuarioDAO usuarioDAO;

	@RequestMapping("login")
	public ModelAndView login(Usuario usuario) {

		return super.login(usuario, usuarioDAO);
	}

	@Override
	protected String getPaginaDeLogin() {
		return "login";
	}

	@Override
	protected String getPaginaDeRetorno() {
		return "redirect:listaDeDesejos";
	}

	@RequestMapping("logout")
	public String logout() {

		adminController.logout();

		return super.logout();
	}

	@RequestMapping("formNovoUsuario")
	public ModelAndView formUsuario() {

		adminController.logout();

		ModelAndView mav = new ModelAndView("formUsuario");

		mav.addObject("isAdmin", adminController.isLogado());

		return mav;
	}

	@RequestMapping("novoUsuario")
	public ModelAndView novoUsuario(Usuario usuario) {

		adminController.logout();

		usuarioDAO.save(usuario);

		return super.login(usuario, usuarioDAO);
	}
}
