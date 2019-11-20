package com.modelo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import com.modelo.repository.LivroRepository;

@Controller
public class ListarController {

	@Autowired
	LivroRepository lv;
	
	
	@GetMapping("/listar")
	private ModelAndView getlistar(){
	
		ModelAndView mv = new ModelAndView("listar");
		mv.addObject("livro", lv.findAll());
		
		return mv;
	}
	

	@GetMapping("/listar/{identificador}")
	private ModelAndView deletar(@PathVariable(value="identificador") int id) {
		lv.deleteById(id);
		
		ModelAndView mv = new ModelAndView("listar");
		mv.addObject("livro", lv.findAll());
		
		return mv;
	}
	
}
