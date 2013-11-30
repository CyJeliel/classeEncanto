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
	public ModelAndView logout() {

		adminController.logout();

		return super.logout();
	}

	@RequestMapping("cadastroDeUsuario")
	public ModelAndView cadastroDeUsuario() {

		ModelAndView mav = new ModelAndView("formUsuario");

		mav.addObject("usuario", usuario);

		finaliza(mav);

		return mav;
	}

	@RequestMapping("salvarUsuario")
	public ModelAndView salvarUsuario(Usuario usuario) {

		if (usuario.getId() == 0) {

			usuarioDAO.save(usuario);

		} else {

			usuarioDAO.merge(usuario);
		}

		if (!adminController.isLogado()) {

			if (usuario.isAdmin()) {

				return adminController.login((Administrador) usuario);

			} else {

				return super.login(usuario, usuarioDAO);
			}

		} else {

			usuario = null;

			ModelAndView mav = new ModelAndView("redirect:listaDeUsuarios");

			finaliza(mav);

			return mav;
		}
	}

	@RequestMapping("excluirUsuario")
	public ModelAndView excluirUsuario(Usuario usuario) {

		ModelAndView mav = new ModelAndView("loginAdmin");

		if (adminController.isLogado()) {

			usuarioDAO.delete(usuario);

			mav.setViewName("redirect:listaDeUsuarios");

		}

		finaliza(mav);

		return mav;
	}

	@RequestMapping("formAlterarDadosUsuario")
	public ModelAndView formAlterarDadosUsuario(Long idUsuario) {

		ModelAndView mav = new ModelAndView("loginAdmin");

		if (adminController.isLogado()) {

			usuario = usuarioDAO.findById(idUsuario);

			mav.setViewName("redirect:cadastroDeUsuario");
		}

		finaliza(mav);

		return mav;
	}

	@RequestMapping("listaDeUsuarios")
	public ModelAndView listaDeUsuarios() {

		ModelAndView mav = new ModelAndView();

		if (adminController.isLogado()) {

			mav.setViewName("listaDeUsuarios");

			List<Usuario> listaDeUsuarios = usuarioDAO.findAll();

			mav.addObject("listaDeUsuarios", listaDeUsuarios);

		} else {

			mav.setViewName("loginAdmin");
		}

		finaliza(mav);

		return mav;
	}
}
