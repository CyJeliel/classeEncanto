package br.com.classeencanto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListagemDeProdutosController {
	@RequestMapping({ "/listagemDeProdutos" })
	public String execute() {
		return "listagemDeProdutos";
	}
}