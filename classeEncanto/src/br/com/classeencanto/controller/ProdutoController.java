package br.com.classeencanto.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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

	private List<String> feedbacks;

	public ProdutoController() {

		feedbacks = new ArrayList<>();
	}

	@RequestMapping({ "/", "/home" })
	public ModelAndView produtosEmDestaque() {

		ModelAndView mav = new ModelAndView();

		List<Destaque> listaDeDestaques = produtoDao.findListaDeDestaques();

		mav.addObject("listaDeDestaques", listaDeDestaques);

		mav.addObject("isAdmin", adminController.isLogado());

		mav.setViewName("home");

		return mav;
	}

	@RequestMapping({ "/getDestaquehome" })
	public void produtoEmDestaque(Integer posicao, HttpServletResponse response) {

		Destaque destaque = produtoDao.findDestaque(posicao);

		if (destaque != null && destaque.getImagem() != null) {

			byte[] thumb = destaque.getImagem();

			String name = "destaque";
			response.setContentType("image/jpeg");
			response.setContentLength(thumb.length);

			response.setHeader("Content-Disposition", "inline; filename=\""
					+ name + "\"");

			BufferedInputStream input = null;
			BufferedOutputStream output = null;

			try {
				input = new BufferedInputStream(new ByteArrayInputStream(thumb));
				output = new BufferedOutputStream(response.getOutputStream());
				byte[] buffer = new byte[8192];
				int length;
				while ((length = input.read(buffer)) > 0) {
					output.write(buffer, 0, length);
				}
			} catch (IOException e) {
				System.out
						.println("There are errors in reading/writing image stream "
								+ e.getMessage());
			} finally {
				if (output != null)
					try {
						output.close();
					} catch (IOException ignore) {
					}
				if (input != null)
					try {
						input.close();
					} catch (IOException ignore) {
					}
			}

		}
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

			List<String> feedbacks = new ArrayList<>();

			feedbacks.addAll(this.feedbacks);

			mav.addObject("feedbacks", feedbacks);

		} else {

			mav.setViewName("loginAdmin");
		}

		feedbacks.clear();

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

		String retorno = "login";

		if (adminController.isLogado()) {

			feedbacks.clear();

			retorno = "redirect:cadastroDeProduto";

			if (produto.valido(feedbacks)) {

				produtoDao.save(produto);
			}
		}

		return retorno;
	}

}