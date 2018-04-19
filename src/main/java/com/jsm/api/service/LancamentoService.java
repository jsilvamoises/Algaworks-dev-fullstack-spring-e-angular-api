package com.jsm.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.jsm.api.filter.LancamentoFilter;
import com.jsm.api.model.Lancamento;
import com.jsm.api.repository.LancamentoRepository;

@Repository
public class LancamentoService extends ServiceInterfaceImpl<Lancamento, LancamentoRepository> {

	@Autowired
	private PessoaService pesService;
	
	@Autowired
	private CategoriaService catService;
	
	
	@Override
	public Lancamento save(Lancamento lancamento) {				
		lancamento.setCategoria(catService.findById(lancamento.getCategoria().getId()));
		lancamento.setPessoa(pesService.findById(lancamento.getPessoa().getId()));		
		return super.save(lancamento);
	}
	
	public Page<Lancamento> filtrar(LancamentoFilter filter,Pageable pageable){
		return getRepository().filtrar(filter,pageable);
	}
}
