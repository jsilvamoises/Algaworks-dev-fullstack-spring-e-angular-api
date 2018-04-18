package com.jsm.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsm.api.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long> {

	public List<Pessoa> findByNomeContainingIgnoreCase(String nome);
	
}
