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

import com.example.demo.entity.ItemVenda;
import com.example.demo.service.ItemVendaService;

@RestController
public class ItemVendaController {

    @Autowired
    private ItemVendaService itemVendaService;

    @PostMapping("/itemVenda")
    public ItemVenda adicionar(@Valid @RequestBody ItemVenda itemVenda) {
        return this.itemVendaService.adicionar(itemVenda);
    }

    @GetMapping("/itemVenda")
    public List<ItemVenda> listar() {
        return this.itemVendaService.listar();
    }

    @PutMapping("/itemVenda")
    public ItemVenda editar(@Valid @RequestBody ItemVenda itemVenda) throws Exception {
        return this.itemVendaService.editar(itemVenda);
    }

    @DeleteMapping("/itemVenda/{idItemVenda}")
    public Map<String, Boolean> remover(@PathVariable(value = "idItemVenda") String idItemVenda) throws Exception {
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", this.itemVendaService.remover(idItemVenda));
        return response;
    }

    @GetMapping("/itemVenda/{idItemVenda}")
    public ItemVenda obterById(@PathVariable(value = "idItemVenda") String idItemVenda) throws Exception {
        return this.itemVendaService.obterById(idItemVenda);
    }
    
}
