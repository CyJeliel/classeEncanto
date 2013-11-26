package br.com.classeencanto.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.classeencanto.dao.ListaDeDesejosDAO;
import br.com.classeencanto.dao.ProdutoDAO;
import br.com.classeencanto.model.impl.Produto;
import br.com.classeencanto.model.impl.Usuario;
import br.com.classeencanto.model.impl.UsuarioProduto;

@Controller
public class ListaDeDesejosController {

	@Autowired
	private AdminController adminController;

	@Autowired
	private UsuarioController loginController;

	@Autowired
	private ListaDeDesejosDAO listaDeDesejosDao;

	@Autowired
	private ProdutoDAO produtoDAO;

	@RequestMapping("listaDeDesejos")
	public ModelAndView listaDeDesejos() {

		ModelAndView mav = new ModelAndView();

		if (loginController.isLogado() || adminController.isLogado()) {

			mav.setViewName("listaDeDesejos");

			Set<UsuarioProduto> listaDeDesejos = listaDeDesejosDao
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

			mav.setViewName("redirect:listaDeDesejos");

			UsuarioProduto usuarioProduto = buildUsuarioProduto(produtoId);

			listaDeDesejosDao.addToListaDeDesejos(usuarioProduto);

		} else {

			mav.setViewName("login");
		}

		return mav;
	}

	private UsuarioProduto buildUsuarioProduto(Long produtoId) {

		Produto produto = produtoDAO.findById(produtoId);

		UsuarioProduto usuarioProduto = new UsuarioProduto();

		usuarioProduto.setProduto(produto);

		usuarioProduto.setUsuario(loginController.usuario);

		usuarioProduto.setQuantidade(1);

		return usuarioProduto;
	}

	@RequestMapping("excluirProdutoListaDeDesejos")
	public String excluirProdutoListaDeDesejos(String idProduto) {

		String retorno;

		if (loginController.isLogado() || adminController.isLogado()) {

			Usuario usuario = listaDeDesejosDao.excluirProdutoListaDeDesejos(
					idProduto, loginController.usuario);

			loginController.usuario = usuario;

			retorno = "redirect:listaDeDesejos";

		} else {

			retorno = "loginAdmin";
		}

		return retorno;
	}

}
