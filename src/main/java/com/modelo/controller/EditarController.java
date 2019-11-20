package com.modelo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.modelo.model.Livro;
import com.modelo.repository.LivroRepository;

@Controller
public class EditarController {
	
	@Autowired
	LivroRepository lv;
	
	@GetMapping("/editar/{identificador}")
	private ModelAndView editar(@PathVariable(value="identificador") int id) {
		
		ModelAndView mv = new ModelAndView("editar");
		mv.addObject("livro", lv.findById(id));
		
		return mv;
	}
	
	@PostMapping("/atualizar")
	private ModelAndView atualizar(Livro l) {
		lv.save(l);
		
		ModelAndView mv = new ModelAndView("listar");
		mv.addObject("livro", lv.findAll());
		
		return mv;
	}
}
