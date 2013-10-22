package br.com.classeencanto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.classeencanto.dao.ProdutoDAO;
import br.com.classeencanto.model.impl.Usuario;

@Controller
public class ProdutoController {

	@Autowired
	private AdminController adminController;
	@Autowired
	private ProdutoDAO produtoDao;

	@RequestMapping({ "/", "/home" })
	public String produtosEmDestaque() {
		
		return "home";
	}
	
	@RequestMapping("produtoDestaque")
	public String cadastroProdutosEmDestaque(Usuario usuario) {
		
		if (adminController.isLogado()){
		
			return "cadastroProdutosEmDestaque";
		}
		
		return "login";
	}

	@RequestMapping({ "/cadastroDeProduto" })
	public ModelAndView cadastroDeProduto(String idProduto) {
		
		ModelAndView mav = new ModelAndView();

		if (adminController.isLogado()){

			mav.setViewName("cadastroDeProduto");
        
		} else {
		
			mav.setViewName("login");
		}
		
		return mav;

	}
	
	@RequestMapping("listaDeProdutos")
	public String listaDeProdutos() {
	
		return "listaDeProdutos";
	}

}
