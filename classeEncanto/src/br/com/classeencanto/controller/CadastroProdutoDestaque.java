package br.com.classeencanto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.classeencanto.model.impl.Usuario;

@Controller
public class CadastroProdutoDestaque {

	@RequestMapping("produtoDestaque")
	public String login(Usuario usuario) {
		return "cadastroProdutosEmDestaque";
	}

	
	
}
