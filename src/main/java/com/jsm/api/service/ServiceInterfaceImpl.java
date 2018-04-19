package com.jsm.api.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jsm.api.error.ObjectNotFoundException;

public abstract class ServiceInterfaceImpl<T, J extends JpaRepository<T, Long>> implements ServiceInterface<T> {

	@Autowired
	private J repository;

	@Override
	public T findById(Long id) {
		Optional<T> object = repository.findById(id);
		if (!object.isPresent()) {
			throw new ObjectNotFoundException("Objeto não encontrado!!! :(");
		}

		return object.get();
	}

	@Override
	public List<T> findAll() {
		return repository.findAll();
	}

	@Override
	public Page<T> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public void deleteById(Long id) {
		findById(id);
		repository.deleteById(id);
	}

	@Override
	public void delete(T object) {	
		Long id = getId(object);
		findById(id);
		repository.delete(object);
	}

	@Override
	public void delete(List<T> objects) {
		repository.deleteAll(objects);

	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override
	public T update(Long id, T object) {
		T saved = findById(id);
		BeanUtils.copyProperties(object, saved, "id");
        saved =  repository.save(saved);
		return saved;
	}

	@Override
	public T save(T object) {
		object = repository.save(object);
		return object;
	}

	@Override
	public List<T> saveAll(List<T> objects) {
		objects = repository.saveAll(objects);
		return objects;
	}
	
	
	
	public Long getId(Object obj) {
		Long id = -1L;
		try {
			Method m = obj.getClass().getMethod("getId");
			m.setAccessible(true);
			id = (Long) m.invoke(obj);
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id;
	}
	
	public J getRepository() {
		return repository;
	}

}
