package br.com.classeencanto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListaDeDesejosController {
	
	@RequestMapping("listaDeDesejos")
	public String listaDeDesejos() {
		return "listaDeDesejos";
	}

}
