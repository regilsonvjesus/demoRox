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

import com.example.demo.entity.Cliente;
import com.example.demo.service.ClienteService;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cliente")
    public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
        return this.clienteService.adicionar(cliente);
    }

    @GetMapping("/cliente")
    public List<Cliente> listar() {
        return this.clienteService.listar();
    }

    @PutMapping("/cliente")
    public Cliente editar(@Valid @RequestBody Cliente cliente) throws Exception {
        return this.clienteService.editar(cliente);
    }

    @DeleteMapping("/cliente/{idCliente}")
    public Map<String, Boolean> remover(@PathVariable(value = "idCliente") String idCliente) throws Exception {
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", this.clienteService.remover(idCliente));
        return response;
    }

    @GetMapping("/cliente/{idCliente}")
    public Cliente obterById(@PathVariable(value = "idCliente") String idCliente) throws Exception {
        return this.clienteService.obterById(idCliente);
    }
    
}
