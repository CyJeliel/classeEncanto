package br.com.classeencanto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FaleConoscoController {
	@RequestMapping({ "/faleConosco" })
	public String execute() {
		return "faleConosco";
	}
}