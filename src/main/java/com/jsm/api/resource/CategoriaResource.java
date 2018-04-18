package com.jsm.api.resource;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsm.api.model.Categoria;
import com.jsm.api.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource extends ResourceInterfaceImpl<Categoria, CategoriaService>{

	
	
	@GetMapping(params = "nome")
	public ResponseEntity<List<Categoria>> findByNome(@PathParam("nome") String nome) {
		List<Categoria> categorias = service.findByNomeContainingIgnoreCase(nome);
		return ResponseEntity.ok(categorias);
	}

}
