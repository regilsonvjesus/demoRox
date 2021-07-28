package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ItemVenda;
import com.example.demo.entity.Venda;
import com.example.demo.repository.ItemVendaRepository;

@Service
public class ItemVendaService {
	
	private static final String NAO_ENCONTRADO = "Produto não encontrado!";
	
	@Autowired
	private ItemVendaRepository itemVendaRepository;

	public ItemVenda adicionar(ItemVenda itemVenda) {
		return this.itemVendaRepository.save(itemVenda);
	}

	public List<ItemVenda> listar() {
		return this.itemVendaRepository.findAll();
	}

	public ItemVenda editar(ItemVenda itemVenda) throws Exception {
		if (itemVenda.getId() == null || (itemVenda.getId().isEmpty())) {
			throw new Exception(NAO_ENCONTRADO);
		}
		return this.itemVendaRepository.save(itemVenda);
	}

	public Boolean remover(String idItemVenda) throws Exception {
		if (idItemVenda == null) {
			throw new Exception(NAO_ENCONTRADO);
		}
		this.itemVendaRepository.deleteById(idItemVenda);
		return Boolean.TRUE;
	}

	public ItemVenda obterById(String idItemVenda) throws Exception {
		if (idItemVenda == null) {
			throw new Exception(NAO_ENCONTRADO);
		}
		return this.itemVendaRepository.findById(idItemVenda).orElse(new ItemVenda());
	}

}
