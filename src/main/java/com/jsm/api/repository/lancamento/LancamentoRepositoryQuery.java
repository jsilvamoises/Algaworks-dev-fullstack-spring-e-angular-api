package com.jsm.api.repository.lancamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jsm.api.filter.LancamentoFilter;
import com.jsm.api.model.Lancamento;

public interface LancamentoRepositoryQuery {
	public Page<Lancamento> filtrar(LancamentoFilter filter,Pageable pageable);
}
