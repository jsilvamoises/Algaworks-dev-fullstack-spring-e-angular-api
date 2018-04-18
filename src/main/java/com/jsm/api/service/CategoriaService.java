package com.jsm.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsm.api.model.Categoria;
import com.jsm.api.repository.CategoriaRepository;

@Service	
public class CategoriaService extends ServiceInterfaceImpl<Categoria, CategoriaRepository> {

	@Autowired
	private CategoriaRepository repository;
	
	public List<Categoria> findByNomeContainingIgnoreCase(String nome ){
		return repository.findByNomeContainingIgnoreCase(nome);
	}
//	public Categoria findById(Long id){
//		Optional<Categoria> cat = repository.findById(id);
//		if(!cat.isPresent()) {
//			throw new ObjectNotFoundException("Objeto não encontrado!!!");
//		}
//		
//		return cat.get();
//	}
}
