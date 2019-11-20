package com.modelo.model;

public abstract class Validador {
	
	public boolean TextoValidadorNLetras(String text, int max, int min) {
		return text.length() <= max && text.length() >= min;
	}
	
	public boolean NumeroValidador(Integer num, int max, int min) {
		return num <= max && num >= min;
	}

}
