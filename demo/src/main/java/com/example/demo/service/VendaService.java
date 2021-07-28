package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Venda;
import com.example.demo.repository.VendaRepository;

@Service
public class VendaService {
	
	private static final String NAO_ENCONTRADO = "Produto não encontrado!";
	
	@Autowired
	private VendaRepository vendaRepository;

	public Venda adicionar(Venda venda) {
		return this.vendaRepository.save(venda);
	}

	public List<Venda> listar() {
		return this.vendaRepository.findAll();
	}

	public Venda editar(Venda venda) throws Exception {
		if (venda.getId() == null || (venda.getId().isEmpty())) {
			throw new Exception(NAO_ENCONTRADO);
		}
		return this.vendaRepository.save(venda);
	}

	public Boolean remover(String idVenda) throws Exception {
		if (idVenda == null) {
			throw new Exception(NAO_ENCONTRADO);
		}
		this.vendaRepository.deleteById(idVenda);
		return Boolean.TRUE;
	}

	public Venda obterById(String idVenda) throws Exception {
		if (idVenda == null) {
			throw new Exception(NAO_ENCONTRADO);
		}
		return this.vendaRepository.findById(idVenda).orElse(new Venda());
	}

}
