package com.jsm.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsm.api.model.Endereco;
import com.jsm.api.model.Pessoa;
import com.jsm.api.repository.EnderecoRepository;

@Service
public class EnderecoService extends ServiceInterfaceImpl<Endereco, EnderecoRepository> {

	@Autowired
	private EnderecoRepository repository;
	
	public List<Endereco> findByPessoaId(Long id){
		return repository.findByPessoaId(id);
	}
	
	
	
	public List<Endereco> findByPessoaId(Pessoa pessoa){
		return repository.findByPessoa(pessoa);
	}
}
