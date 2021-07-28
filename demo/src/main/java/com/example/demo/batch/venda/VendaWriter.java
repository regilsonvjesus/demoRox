package com.example.demo.batch.venda;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Venda;
import com.example.demo.repository.VendaRepository;

@Component(value = "vendaWriter")
public class VendaWriter implements ItemWriter<Venda> {

	static final Logger log = Logger.getLogger(VendaWriter.class); 
	
	@Autowired
    private VendaRepository vendaRepository;

    @Override
    public void write(List<? extends Venda> vendas) throws Exception {
    	vendaRepository.saveAll(vendas);
    }
}
