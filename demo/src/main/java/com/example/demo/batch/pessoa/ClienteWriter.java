package com.example.demo.batch.pessoa;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Cliente;
import com.example.demo.repository.ClienteRepository;

@Component(value = "clienteWriter")
public class ClienteWriter implements ItemWriter<Cliente> {

	static final Logger log = Logger.getLogger(ClienteWriter.class); 
	
	@Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void write(List<? extends Cliente> clientes) throws Exception {
    	clienteRepository.saveAll(clientes);
    }
}
