package com.jsm.api.model;

import java.io.Serializable;

public enum LancamentoTipo implements Serializable {

	RECEITA(1, "Receita"), DESPESA(2, "Despesa");

	
	private int id;
	private String descricao;

	LancamentoTipo(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
