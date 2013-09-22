package br.com.classeencanto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListaDeProdutosController {
	@RequestMapping("listaDeProdutos")
	public String execute() {
		return "listaDeProdutos";
	}
}