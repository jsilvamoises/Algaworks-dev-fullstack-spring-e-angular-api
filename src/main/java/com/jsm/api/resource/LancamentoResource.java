package com.jsm.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsm.api.filter.LancamentoFilter;
import com.jsm.api.model.Lancamento;
import com.jsm.api.service.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource extends ResourceInterfaceImpl<Lancamento, LancamentoService> {

	@Autowired
	private LancamentoService service;
	
	@GetMapping("/filtrar")
	public ResponseEntity<Page<Lancamento>> filtrar(LancamentoFilter filter,Pageable pageable){
		Page<Lancamento> lancamentos = service.filtrar(filter,pageable);
		return ResponseEntity.ok(lancamentos);
	}
}
