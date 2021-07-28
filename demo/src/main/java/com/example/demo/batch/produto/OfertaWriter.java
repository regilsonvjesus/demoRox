package com.example.demo.batch.produto;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Oferta;
import com.example.demo.repository.OfertaRepository;

@Component(value = "ofertaWriter")
public class OfertaWriter implements ItemWriter<Oferta> {

	static final Logger log = Logger.getLogger(OfertaWriter.class); 
	
	@Autowired
    private OfertaRepository ofertaRepository;

    @Override
    public void write(List<? extends Oferta> ofertas) throws Exception {
    	ofertaRepository.saveAll(ofertas);
    }
}
