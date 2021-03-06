package com.jsm.api.service;

import org.springframework.stereotype.Service;

import com.jsm.api.model.Pessoa;
import com.jsm.api.repository.PessoaRepository;

@Service
public class PessoaService extends ServiceInterfaceImpl<Pessoa, PessoaRepository>{

	
	@Override
	public Pessoa save(Pessoa object) {	
		object.getEnderecos().forEach(e->{
			e.setPessoa(object);
		});
		return super.save(object);
	}

	public Pessoa updateStatus(Long id) {
		Pessoa pessoa = findById(id);
		pessoa.setAtivo(pessoa.getAtivo()?false:true);
		pessoa = save(pessoa);
		return pessoa;
	}
	
}
