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
public class ProdutoController {

	@Autowired
	private AdminController adminController;

	@Autowired
	private LoginController loginController;

	@Autowired
	private ProdutoDAO produtoDao;

	@RequestMapping({ "/", "/home" })
	public String produtosEmDestaque() {

		return "home";
	}

	@RequestMapping("produtoDestaque")
	public String cadastroProdutosEmDestaque(Usuario usuario) {

		if (adminController.isLogado()) {

			return "cadastroProdutosEmDestaque";
		}

		return "loginAdmin";
	}

	@RequestMapping({ "/cadastroDeProduto" })
	public ModelAndView cadastroDeProduto(String idProduto) {

		ModelAndView mav = new ModelAndView();

		if (adminController.isLogado()) {

			mav.setViewName("cadastroDeProduto");

		} else {

			mav.setViewName("loginAdmin");
		}

		return mav;

	}

	@RequestMapping("detalhesDeProduto")
	public ModelAndView detalhesDeProduto(Long idProduto) {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("detalhesDeProduto");

		Produto produto = produtoDao.findById(idProduto);

		mav.addObject("produto", produto);

		List<Long> itensRelacionados = produtoDao
				.findProdutosRelacionados(idProduto);

		mav.addObject("itensRelacionados", itensRelacionados);

		return mav;
	}

	@RequestMapping("listaDeDesejos")
	public ModelAndView listaDeDesejos() {

		ModelAndView mav = new ModelAndView();

		if (loginController.isLogado()) {
			
			mav.setViewName("listaDeDesejos");

			List<Produto> listaDeDesejos = produtoDao.findListaDeDesejos(loginController.usuario);

			mav.addObject("listaDeDesejos", listaDeDesejos);
			
		} else {

			mav.setViewName("login");
		}
		
		return mav;
	}

	@RequestMapping("listaDeProdutos")
	public String listaDeProdutos() {

		return "listaDeProdutos";
	}

	@RequestMapping("adicionarListaDeDesejos")
	public ModelAndView adicionarListaDeDesejos(Long produtoId) {

		ModelAndView mav = new ModelAndView();

		if (loginController.isLogado()) {
			
			mav.setViewName("listaDeDesejos");

			Produto produto = produtoDao.findById(produtoId);
			
			List<Produto> listaDeDesejos = produtoDao.addToListaDeDesejos(produto, loginController.usuario);

			mav.addObject("listaDeDesejos", listaDeDesejos);
			
		} else {

			mav.setViewName("login");
		}
		
		return mav;
	}

}