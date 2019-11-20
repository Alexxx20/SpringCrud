package com.modelo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.modelo.model.Livro;
import com.modelo.repository.LivroRepository;

@Controller
public class CadastroController {
	
	@Autowired
	private LivroRepository repositorio;
	
	@GetMapping("/cadastro")
	private String getCadastro() {
		return  "cadastro";
	}
	
	@PostMapping("/cadastro")
	private String salvar(Livro l) {
		repositorio.save(l);
		return "/cadastro/novo";
	}
}
