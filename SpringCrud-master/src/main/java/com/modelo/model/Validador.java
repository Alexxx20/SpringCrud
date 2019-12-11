package com.modelo.model;

public class Validador {
	
	public boolean TextoValidador(String text, int max, int min) {
		return text.length() <= max && text.length() >= min;
	}
	
	public boolean NumeroValidador(int num, int max, int min) {
		return num <= max && num >= min;
	}
}

