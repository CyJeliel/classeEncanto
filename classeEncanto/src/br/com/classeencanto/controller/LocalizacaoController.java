package br.com.classeencanto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LocalizacaoController {
	@RequestMapping({ "/localizacao" })
	public String execute() {
		return "localizacao";
	}
}