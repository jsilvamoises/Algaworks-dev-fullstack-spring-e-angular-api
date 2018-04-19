package com.jsm.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsm.api.filter.LancamentoFilter;
import com.jsm.api.model.Lancamento;
import com.jsm.api.repository.lancamento.LancamentoRepositoryQuery;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento,Long>, LancamentoRepositoryQuery {

	
	
}
