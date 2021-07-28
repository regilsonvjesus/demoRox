package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Cliente;

public interface ClienteRepositoryCustom {

    public List<Cliente> findByPessoaIdIsNotNull();

}