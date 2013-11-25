package br.com.classeencanto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.classeencanto.dao.ProdutoDAO;
import br.com.classeencanto.model.impl.Produto;
import br.com.classeencanto.model.impl.Usuario;

@Controller
public class ListaDeDesejosController {

	@Autowired
	private AdminController adminController;

	@Autowired
	private UsuarioController loginController;

	@Autowired
	private ProdutoDAO produtoDao;

	@RequestMapping("listaDeDesejos")
	public ModelAndView listaDeDesejos() {

		ModelAndView mav = new ModelAndView();

		if (loginController.isLogado() || adminController.isLogado()) {

			mav.setViewName("listaDeDesejos");

			List<Produto> listaDeDesejos = produtoDao
					.findListaDeDesejos(loginController.usuario);

			mav.addObject("listaDeDesejos", listaDeDesejos);

			mav.addObject("isAdmin", adminController.isLogado());

		} else {

			mav.setViewName("login");
		}

		return mav;
	}

	@RequestMapping("adicionarListaDeDesejos")
	public ModelAndView adicionarListaDeDesejos(Long produtoId) {

		ModelAndView mav = new ModelAndView();

		if (loginController.isLogado() || adminController.isLogado()) {

			mav.setViewName("listaDeDesejos");

			Produto produto = produtoDao.findById(produtoId);

			List<Produto> listaDeDesejos = produtoDao.addToListaDeDesejos(
					produto, loginController.usuario);

			mav.addObject("listaDeDesejos", listaDeDesejos);

			mav.addObject("isAdmin", adminController.isLogado());

		} else {

			mav.setViewName("login");
		}

		return mav;
	}

	@RequestMapping("excluirProdutoListaDeDesejos")
	public String excluirProdutoListaDeDesejos(String idProduto) {

		String retorno;

		if (loginController.isLogado() || adminController.isLogado()) {

			Usuario usuario = produtoDao.excluirProdutoListaDeDesejos(idProduto,
					loginController.usuario);

			loginController.usuario = usuario;

			retorno = "redirect:listaDeDesejos";

		} else {

			retorno = "loginAdmin";
		}

		return retorno;
	}

}
