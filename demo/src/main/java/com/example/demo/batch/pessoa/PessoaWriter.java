package com.example.demo.batch.pessoa;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Pessoa;
import com.example.demo.repository.PessoaRepository;

@Component(value = "pessoaWriter")
public class PessoaWriter implements ItemWriter<Pessoa> {

	static final Logger log = Logger.getLogger(PessoaWriter.class); 
	
	@Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public void write(List<? extends Pessoa> pessoas) throws Exception {
    	pessoaRepository.saveAll(pessoas);
    }
}
