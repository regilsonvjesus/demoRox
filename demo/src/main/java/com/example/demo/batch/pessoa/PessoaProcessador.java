package com.example.demo.batch.pessoa;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Pessoa;

@Component("pessoaProcessor")
public class PessoaProcessador implements ItemProcessor<Pessoa, Pessoa> {
	
	static final Logger log = Logger.getLogger(PessoaProcessador.class);

	@Override
	public Pessoa process(Pessoa pessoa) throws Exception {
		return pessoa;
		/*
		Pessoa transformedPerson = null;
		try {

			final String firstName = pessoa.getNome().toUpperCase();
			transformedPerson = new Pessoa(firstName);
			log.info("Converting (" + pessoa + ") into (" + transformedPerson + ")");		

		} catch (Exception ex) {
			log.error("Erro no pessoaProcessor: " + ex.getMessage());
		}
		return transformedPerson;
		*/
	}
}