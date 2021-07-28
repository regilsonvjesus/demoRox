package com.example.demo.batch.pessoa;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Cliente;

@Component("clienteProcessor")
public class ClienteProcessador implements ItemProcessor<Cliente, Cliente> {
	
	static final Logger log = Logger.getLogger(ClienteProcessador.class);

	@Override
	public Cliente process(Cliente cliente) throws Exception {
		return cliente;
	}
}