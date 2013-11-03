package br.com.classeencanto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.classeencanto.dao.ProdutoDAO;
import br.com.classeencanto.model.impl.Destaque;
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
	public ModelAndView produtosEmDestaque() {

		ModelAndView mav = new ModelAndView();

		List<Destaque> listaDeDestaques = produtoDao.findListaDeDestaques();

		mav.addObject("listaDeDestaques", listaDeDestaques);

		mav.addObject("isAdmin", adminController.isLogado());

		mav.setViewName("home");

		return mav;
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

		mav.addObject("isAdmin", adminController.isLogado());

		return mav;
	}

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

	@RequestMapping("listaDeProdutos")
	public ModelAndView listaDeProdutos() {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("listaDeProdutos");

		List<Produto> listaDeProdutos = produtoDao.findProdutos(null);

		mav.addObject("listaDeProdutos", listaDeProdutos);

		mav.addObject("isAdmin", adminController.isLogado());

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

		} else {

			mav.setViewName("login");
		}

		return mav;
	}

	@RequestMapping("novoProduto")
	public String novoProduto(Produto produto) {

		String retorno = "redirect:cadastroDeProduto";

		if (adminController.isLogado()) {

			if (produto.valido()) {

				produtoDao.save(produto);
			} else {

				retorno = "login";
			}
		}
		return retorno;
	}

}