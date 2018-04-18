package com.jsm.api.resource;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ResourceInterface<T> {
	
	ResponseEntity<T> findById(Long id);

	ResponseEntity<List<T>> findAll();

	ResponseEntity<Page<T>> findAll(Pageable pageable);

	ResponseEntity<Void> deleteById(Long id);

	ResponseEntity<Void> delete(T object);

	ResponseEntity<Void> delete(List<T> objects);

	ResponseEntity<Void> deleteAll();

	ResponseEntity<T> update(Long id, T object);

	ResponseEntity<T> save(T object);

	ResponseEntity<List<T>> saveAll(List<T> objects);
}
