package br.com.classeencanto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.classeencanto.dao.UsuarioDAO;
import br.com.classeencanto.model.impl.Administrador;
import br.com.classeencanto.model.impl.Usuario;

@Controller
public class UsuarioController extends AbstractLoginController {

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

	@RequestMapping("cadastroDeUsuario")
	public ModelAndView cadastroDeUsuario() {

		ModelAndView mav = new ModelAndView("formUsuario");

		mav.addObject("usuario", usuario);

		mav.addObject("isAdmin", adminController.isLogado());

		return mav;
	}

	@RequestMapping("salvarUsuario")
	public ModelAndView salvarUsuario(Usuario usuario) {

		if (usuario.getId() == 0){

			usuarioDAO.save(usuario);

		} else {

			usuarioDAO.merge(usuario);
		}

		if (!adminController.isLogado()){

			if (usuario.isAdmin()){

				return adminController.login((Administrador) usuario);

			} else {

				return super.login(usuario, usuarioDAO);
			}

		} else {

			usuario = null;

			return new ModelAndView("redirect:listaDeUsuarios");
		}
	}

	@RequestMapping("excluirUsuario")
	public String excluirUsuario(Usuario usuario) {

		String retorno;
		if (adminController.isLogado()) {

			usuarioDAO.delete(usuario);

			retorno = "redirect:listaDeUsuarios";

		} else {

			retorno = "loginAdmin";
		}

		return retorno;
	}

	@RequestMapping("formAlterarDadosUsuario")
	public String formAlterarDadosUsuario(Long idUsuario) {

		String retorno = "redirect:admin";

		if (adminController.isLogado()) {

			usuario = usuarioDAO.findById(idUsuario);

			retorno = "redirect:cadastroDeUsuario";
		}

		return retorno;
	}

	@RequestMapping("listaDeUsuarios")
	public ModelAndView listaDeUsuarios() {

		ModelAndView mav = new ModelAndView();

		if (adminController.isLogado()) {

			mav.setViewName("listaDeUsuarios");

			List<Usuario> listaDeUsuarios = usuarioDAO.findAll();

			mav.addObject("listaDeUsuarios", listaDeUsuarios);

			mav.addObject("isAdmin", adminController.isLogado());

		} else {

			mav.setViewName("loginAdmin");
		}

		return mav;
	}
}
