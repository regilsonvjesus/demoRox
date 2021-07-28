package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.Pessoa;

public interface PessoaRepository extends MongoRepository<Pessoa, String> {

}

