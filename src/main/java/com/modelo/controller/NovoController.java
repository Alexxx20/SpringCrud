package com.modelo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NovoController {
	@GetMapping("/novo")
	public String novo() {
		return "novo";
	}
}
