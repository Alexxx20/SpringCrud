package com.modelo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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
	private ModelAndView salvar(Livro l) {
		if(l.getTitulo().length() <= 90){
			if (l.getAutor().length() <= 60) {
				if (l.getDescricao().length() <= 250) {
					if (l.getEstoque() <= 1000) {
						if (l.getGenero().length() <= 60) {
							if (l.getPreco() >= 23) {
								if (l.getNpaginas() <= 10000) {
									repositorio.save(l);
									ModelAndView mv = new ModelAndView("cadastro");
									return mv;
								}
							}
						}
					}
				}
			}
		}
		ModelAndView mv = new ModelAndView("novo");
		return mv;
	}
	
}
