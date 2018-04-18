package com.jsm.api.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jsm.api.model.Categoria;
import com.jsm.api.repository.CategoriaRepository;
import com.jsm.api.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource extends ResourceInterfaceImpl<Categoria, CategoriaService>{

	
	
	@GetMapping(params = "nome")
	public ResponseEntity<List<Categoria>> findByNome(@PathParam("nome") String nome) {
		List<Categoria> categorias = service.findByNomeContainingIgnoreCase(nome);
		return ResponseEntity.ok(categorias);
	}
		
//	@Autowired
//	private CategoriaService service;
//
//	@GetMapping
//	public ResponseEntity<List<Categoria>> findAll() {
//		List<Categoria> categorias = service.findAll();
//		return ResponseEntity.ok(categorias);
//	}
//
//	@GetMapping(params = "nome")
//	public ResponseEntity<List<Categoria>> findByNome(@PathParam("nome") String nome) {
//		List<Categoria> categorias = service.findByNomeContainingIgnoreCase(nome);
//		return ResponseEntity.ok(categorias);
//	}
//
//	@PostMapping
//	public ResponseEntity<Categoria> save(@Valid @RequestBody Categoria categoria, HttpServletResponse res) {
//		categoria = service.save(categoria);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(categoria.getId())
//				.toUri();
//		//res.setHeader("Location", uri.toASCIIString());
//		return ResponseEntity.created(uri).body(categoria);
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<Categoria> findById(@PathVariable Long id){
//		Categoria c = service.findById(id);			
//		return ResponseEntity.ok(c);
//		
//	}
}
