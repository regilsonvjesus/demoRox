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

import com.example.demo.entity.Pessoa;
import com.example.demo.service.PessoaService;

@RestController
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/pessoa")
    public Pessoa adicionar(@Valid @RequestBody Pessoa pessoa) {
        return this.pessoaService.adicionar(pessoa);
    }

    @GetMapping("/pessoa")
    public List<Pessoa> listar() {
        return this.pessoaService.listar();
    }

    @PutMapping("/pessoa")
    public Pessoa editar(@Valid @RequestBody Pessoa pessoa) throws Exception {
        return this.pessoaService.editar(pessoa);
    }

    @DeleteMapping("/pessoa/{idPessoa}")
    public Map<String, Boolean> remover(@PathVariable(value = "idPessoa") String idPessoa) throws Exception {
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", this.pessoaService.remover(idPessoa));
        return response;
    }

    @GetMapping("/pessoa/{idPessoa}")
    public Pessoa obterById(@PathVariable(value = "idPessoa") String idPessoa) throws Exception {
        return this.pessoaService.obterById(idPessoa);
    }
    
}
