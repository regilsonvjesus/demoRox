package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cliente;
import com.example.demo.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private static final String NAO_ENCONTRADO = "Cliente não encontrado!";
	
	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente adicionar(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	public List<Cliente> listar() {
		return this.clienteRepository.findAll();
	}

	public Cliente editar(Cliente cliente) throws Exception {
		if (cliente.getId() == null || (cliente.getId().isEmpty())) {
			throw new Exception(NAO_ENCONTRADO);
		}
		return this.clienteRepository.save(cliente);
	}

	public Boolean remover(String idCliente) throws Exception {
		if (idCliente == null) {
			throw new Exception(NAO_ENCONTRADO);
		}
		this.clienteRepository.deleteById(idCliente);
		return Boolean.TRUE;
	}

	public Cliente obterById(String idCliente) throws Exception {
		if (idCliente == null) {
			throw new Exception(NAO_ENCONTRADO);
		}
		return this.clienteRepository.findById(idCliente).orElse(new Cliente());
	}

}
