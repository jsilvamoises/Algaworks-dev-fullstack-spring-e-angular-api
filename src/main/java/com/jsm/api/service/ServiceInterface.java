package com.jsm.api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceInterface<T> {

	public T findById(Long id);

	public List<T> findAll();

	public Page<T> findAll(Pageable pageable);
	
	public void deleteById(Long id);
	
	public void delete(T object);
	
	public void delete(List<T> objects);
	
	public void deleteAll();
	
	public T update(Long id,T object);	
	
	public T save(T object);
	
	public List<T> saveAll(List<T> objects);
	
	public Long getId(Object obj);
}
