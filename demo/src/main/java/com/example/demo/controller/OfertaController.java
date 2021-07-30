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

import com.example.demo.entity.Oferta;
import com.example.demo.service.OfertaService;

@RestController
public class OfertaController {

    @Autowired
    private OfertaService ofertaService;

    @PostMapping("/oferta")
    public Oferta adicionar(@Valid @RequestBody Oferta oferta) {
        return this.ofertaService.adicionar(oferta);
    }

    @GetMapping("/oferta")
    public List<Oferta> listar() {
        return this.ofertaService.listar();
    }

    @PutMapping("/oferta")
    public Oferta editar(@Valid @RequestBody Oferta oferta) throws Exception {
        return this.ofertaService.editar(oferta);
    }

    @DeleteMapping("/oferta/{idOferta}")
    public Map<String, Boolean> remover(@PathVariable(value = "idOferta") String idOferta) throws Exception {
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", this.ofertaService.remover(idOferta));
        return response;
    }

    @GetMapping("/oferta/{idOferta}")
    public Oferta obterById(@PathVariable(value = "idOferta") String idOferta) throws Exception {
        return this.ofertaService.obterById(idOferta);
    }
    
}
