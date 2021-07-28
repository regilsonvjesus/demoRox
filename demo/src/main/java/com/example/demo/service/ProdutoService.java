package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Produto;
import com.example.demo.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	private static final String NAO_ENCONTRADO = "Produto não encontrado!";
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto adicionar(Produto produto) {
		return this.produtoRepository.save(produto);
	}

	public List<Produto> listar() {
		return this.produtoRepository.findAll();
	}

	public Produto editar(Produto produto) throws Exception {
		if (produto.getId() == null || (produto.getId().isEmpty())) {
			throw new Exception(NAO_ENCONTRADO);
		}
		return this.produtoRepository.save(produto);
	}

	public Boolean remover(String idProduto) throws Exception {
		if (idProduto == null) {
			throw new Exception(NAO_ENCONTRADO);
		}
		this.produtoRepository.deleteById(idProduto);
		return Boolean.TRUE;
	}

	public Produto obterById(String idProduto) throws Exception {
		if (idProduto == null) {
			throw new Exception(NAO_ENCONTRADO);
		}
		return this.produtoRepository.findById(idProduto).orElse(new Produto());
	}

}
