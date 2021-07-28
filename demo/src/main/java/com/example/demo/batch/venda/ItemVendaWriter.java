package com.example.demo.batch.venda;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.ItemVenda;
import com.example.demo.repository.ItemVendaRepository;

@Component(value = "itemVendaWriter")
public class ItemVendaWriter implements ItemWriter<ItemVenda> {

	static final Logger log = Logger.getLogger(ItemVendaWriter.class); 
	
	@Autowired
    private ItemVendaRepository itemVendaRepository;

    @Override
    public void write(List<? extends ItemVenda> itemVendas) throws Exception {
    	itemVendaRepository.saveAll(itemVendas);
    }
}
