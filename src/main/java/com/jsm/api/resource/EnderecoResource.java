package com.jsm.api.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsm.api.model.Endereco;
import com.jsm.api.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoResource extends ResourceInterfaceImpl<Endereco, EnderecoService> {

}
