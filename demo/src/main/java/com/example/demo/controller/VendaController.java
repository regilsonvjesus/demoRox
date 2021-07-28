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

import com.example.demo.entity.Venda;
import com.example.demo.service.VendaService;

@RestController
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping("/venda")
    public Venda adicionar(@Valid @RequestBody Venda venda) {
        return this.vendaService.adicionar(venda);
    }

    @GetMapping("/venda")
    public List<Venda> listar() {
        return this.vendaService.listar();
    }

    @PutMapping("/venda")
    public Venda editar(@Valid @RequestBody Venda venda) throws Exception {
        return this.vendaService.editar(venda);
    }

    @DeleteMapping("/venda/{idVenda}")
    public Map<String, Boolean> remover(@PathVariable(value = "idVenda") String idVenda) throws Exception {
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", this.vendaService.remover(idVenda));
        return response;
    }

    @GetMapping("/venda/{idVenda}")
    public Venda obterById(@PathVariable(value = "idVenda") String idVenda) throws Exception {
        return this.vendaService.obterById(idVenda);
    }
    
}
