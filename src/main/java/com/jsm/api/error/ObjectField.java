package com.jsm.api.error;

public class ObjectField {
	private String nome;
	private String message;

	public ObjectField() {
	}

	public ObjectField(String nome, String message) {
		super();
		this.nome = nome;
		this.message = message;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
