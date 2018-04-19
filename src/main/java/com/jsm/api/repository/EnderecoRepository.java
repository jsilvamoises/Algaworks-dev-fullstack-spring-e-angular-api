package com.jsm.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsm.api.model.Endereco;
import com.jsm.api.model.Pessoa;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	
	public List<Endereco> findByPessoaId(Long id);

	public List<Endereco> findByPessoa(Pessoa pessoa);
}
