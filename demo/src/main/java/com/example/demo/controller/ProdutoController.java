package com.example.demo.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Produto;
import com.example.demo.service.ProdutoService;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/produto")
    public Produto adicionar(@Valid @RequestBody Produto produto) {
        return this.produtoService.adicionar(produto);
    }

    @GetMapping("/produto")
    public List<Produto> listar() {
        return this.produtoService.listar();
    }

    @PutMapping("/produto")
    public Produto editar(@Valid @RequestBody Produto produto) throws Exception {
        return this.produtoService.editar(produto);
    }

    @DeleteMapping("/produto/{idProduto}")
    public Map<String, Boolean> remover(@PathVariable(value = "idProduto") String idProduto) throws Exception {
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", this.produtoService.remover(idProduto));
        return response;
    }

    @GetMapping("/produto/{idProduto}")
    public Produto obterById(@PathVariable(value = "idProduto") String idProduto) throws Exception {
        return this.produtoService.obterById(idProduto);
    }
    
}
