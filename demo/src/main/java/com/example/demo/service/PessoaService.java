package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Pessoa;
import com.example.demo.repository.PessoaRepository;

@Service
public class PessoaService {
	
	private static final String NAO_ENCONTRADO = "Pessoa não encontrado!";
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa adicionar(Pessoa pessoa) {
		return this.pessoaRepository.save(pessoa);
	}

	public List<Pessoa> listar() {
		return this.pessoaRepository.findAll();
	}

	public Pessoa editar(Pessoa pessoa) throws Exception {
		if (pessoa.getId() == null || (pessoa.getId().isEmpty())) {
			throw new Exception(NAO_ENCONTRADO);
		}
		return this.pessoaRepository.save(pessoa);
	}

	public Boolean remover(String idPessoa) throws Exception {
		if (idPessoa == null) {
			throw new Exception(NAO_ENCONTRADO);
		}
		this.pessoaRepository.deleteById(idPessoa);
		return Boolean.TRUE;
	}

	public Pessoa obterById(String idPessoa) throws Exception {
		if (idPessoa == null) {
			throw new Exception(NAO_ENCONTRADO);
		}
		return this.pessoaRepository.findById(idPessoa).orElse(new Pessoa());
	}

}
