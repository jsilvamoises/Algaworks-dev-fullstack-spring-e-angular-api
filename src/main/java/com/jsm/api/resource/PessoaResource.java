package com.jsm.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsm.api.model.Endereco;
import com.jsm.api.model.Pessoa;
import com.jsm.api.service.EnderecoService;
import com.jsm.api.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource extends ResourceInterfaceImpl<Pessoa, PessoaService> {

	@Autowired
	private PessoaService service;
	
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping("/{id}/enderecos")
	public ResponseEntity<List<Endereco>> enderecosByPessoa(@PathVariable Long id){
		List<Endereco> enderecos = enderecoService.findByPessoaId(id);
		return ResponseEntity.ok(enderecos);
	}
	
	@GetMapping("/enderecos")
	public ResponseEntity<List<Endereco>> enderecosByPessoa(@RequestBody Pessoa pessoa){
		List<Endereco> enderecos = enderecoService.findByPessoaId(pessoa);
		return ResponseEntity.ok(enderecos);
	}
	
	@PutMapping("/{id}/status")
	public ResponseEntity<Pessoa> ativarDesativar(@PathVariable Long id){
		Pessoa pessoa = service.updateStatus(id);		
		return ResponseEntity.ok(pessoa);
	}
}
