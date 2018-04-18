package com.jsm.api.resource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jsm.api.service.ServiceInterface;

public abstract class ResourceInterfaceImpl<T, S extends ServiceInterface<T>> implements ResourceInterface<T> {

	@Autowired
	S service;

	@GetMapping("/{id}")
	@Override
	public ResponseEntity<T> findById(@PathVariable Long id) {
		T obj = service.findById((Long)id);
		return ResponseEntity.ok(obj);
	}

	@GetMapping
	@Override
	public ResponseEntity<List<T>> findAll() {
		List<T> objs = service.findAll();
		return ResponseEntity.ok(objs);
	}
    @GetMapping("/paged")
	@Override
	public ResponseEntity<Page<T>> findAll(Pageable pageable) {
		Page<T> page = service.findAll(pageable);
		return ResponseEntity.ok(page);
	}

    @DeleteMapping("/{id}")
	@Override
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

    @DeleteMapping
	@Override
	public ResponseEntity<Void> delete(@RequestBody T object) {
		service.delete(object);
		return ResponseEntity.noContent().build();
	}

    /**
     * Implementar apenas nas classes que precisarem
     */
    //@DeleteMapping("/inlist")
	@Override
	public ResponseEntity<Void> delete(@RequestBody List<T> objects) {
		service.delete(objects);
		return ResponseEntity.noContent().build();
	}
	/**
     * Implementar apenas nas classes que precisarem
     */
    //@DeleteMapping("/all")
	@Override
	public ResponseEntity<Void> deleteAll() {
        service.deleteAll();
		return ResponseEntity.noContent().build();
	}

    @PutMapping
	@Override
	public ResponseEntity<T> update(Long id, T object) {
		object = service.update(id, object);
		return ResponseEntity.ok(object);
	}

    @PostMapping
	@Override
	public ResponseEntity<T> save(@Valid @RequestBody T object) {
		object = service.save(object);
		Long id = service.getId(object);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(id).toUri();

		return ResponseEntity.created(uri).body(object);
	}

	@PostMapping(params="array")
	@Override
	public ResponseEntity<List<T>> saveAll(@Valid @RequestBody List<T> objects) {
		objects = service.saveAll(objects);
		Long id = service.getId(objects.get(0));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(uri).body(objects);
	}

	

}
