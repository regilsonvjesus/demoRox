package com.example.demo.batch.produto;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Produto;
import com.example.demo.repository.ProdutoRepository;

@Component(value = "produtoWriter")
public class ProdutoWriter implements ItemWriter<Produto> {

	static final Logger log = Logger.getLogger(ProdutoWriter.class); 
	
	@Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void write(List<? extends Produto> produtos) throws Exception {
    	produtoRepository.saveAll(produtos);
    }
}
