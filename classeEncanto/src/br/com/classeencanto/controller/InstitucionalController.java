package br.com.classeencanto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InstitucionalController {
	@RequestMapping({ "/institucional" })
	public String execute() {
		return "institucional";
	}
}