package com.jsm.api.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsm.api.model.Pessoa;
import com.jsm.api.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource extends ResourceInterfaceImpl<Pessoa, PessoaService> {

}
