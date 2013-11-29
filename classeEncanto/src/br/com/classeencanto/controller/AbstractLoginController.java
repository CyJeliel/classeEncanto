package br.com.classeencanto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import br.com.classeencanto.dao.CategoriaDAO;
import br.com.classeencanto.dao.UsuarioDAO;
import br.com.classeencanto.model.impl.Categoria;
import br.com.classeencanto.model.impl.Usuario;

public abstract class AbstractLoginController {

	@Autowired
	private CategoriaDAO categoriaDao;

	private List<Categoria> categoriasMenu;

	protected Usuario usuario;

	protected List<String> feedbacks;

	public AbstractLoginController() {

		feedbacks = new ArrayList<>();
	}

	public ModelAndView login(Usuario usuario, UsuarioDAO usuarioDAO) {

		feedbacks.clear();

		ModelAndView mav = new ModelAndView();

		String retorno;

		Usuario usuarioDB = usuario.existe(usuarioDAO);

		if (isLogado() || usuarioDB != null) {

			this.usuario = usuarioDB;

			retorno = getPaginaDeRetorno();

		} else {

			String login = usuario.getLogin();

			String senha = usuario.getSenha();

			if ((login != null && !login.isEmpty()) || (senha != null && !senha.isEmpty())) {

				feedbacks.add("Login ou senha incorretos.");

				mav.addObject("feedbacks", feedbacks);
			}

			retorno = getPaginaDeLogin();

		}

		mav.setViewName(retorno);

		finaliza(mav);

		return mav;
	}

	public boolean isLogado() {

		if (usuario == null) {

			return false;
		}

		return true;
	}

	public ModelAndView logout() {

		this.usuario = null;

		ModelAndView mav = new ModelAndView(getPaginaDeLogin());

		finaliza(mav);

		return mav;
	}

	abstract protected String getPaginaDeLogin();

	abstract protected String getPaginaDeRetorno();

	protected ModelAndView finaliza(ModelAndView mav) {

		mav.addObject("isAdmin", usuario.isAdmin());

		mav.addObject("categoriasMenu", getCategoriasMenu());

		return mav;
	}

	public List<Categoria> getCategoriasMenu() {

		if (categoriasMenu == null){

			categoriasMenu = categoriaDao.findAll();
		}

		return categoriasMenu;
	}

}
