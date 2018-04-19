package com.jsm.api.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="lancamento")
public class Lancamento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="data_vencimento")
	private LocalDate dataVencimento;
	
	@Column(name="data_pagamento")
	private LocalDate dataPagamento;
	
	@Column(name="valor")
	private BigDecimal valor;
	
	@Column(name="observacao")
	private String observacao;
	
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria;
	
	@Column(name="tipo")
	@Enumerated(EnumType.STRING)
	private LancamentoTipo tipo;
	
	@ManyToOne
	@JoinColumn(name="pessoa_id")
	private Pessoa pessoa;

	public Lancamento() {
		super();
		
	}

	public Lancamento(Long id, LocalDate dataVencimento, LocalDate dataPagamento, BigDecimal valor, String observacao,
			Categoria categoria, LancamentoTipo tipo, Pessoa pessoa) {
		super();
		this.id = id;
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
		this.valor = valor;
		this.observacao = observacao;
		this.categoria = categoria;
		this.tipo = tipo;
		this.pessoa = pessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public LancamentoTipo getTipo() {
		return tipo;
	}

	public void setTipo(LancamentoTipo tipo) {
		this.tipo = tipo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lancamento other = (Lancamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Lancamento [id=");
		builder.append(id);
		builder.append(", dataVencimento=");
		builder.append(dataVencimento);
		builder.append(", dataPagamento=");
		builder.append(dataPagamento);
		builder.append(", valor=");
		builder.append(valor);
		builder.append(", observacao=");
		builder.append(observacao);
		builder.append(", categoria=");
		builder.append(categoria);
		builder.append(", tipo=");
		builder.append(tipo);
		builder.append(", pessoa=");
		builder.append(pessoa);
		builder.append("]");
		return builder.toString();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	

}
