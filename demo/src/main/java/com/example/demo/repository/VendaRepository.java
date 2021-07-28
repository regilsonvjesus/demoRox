package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.Venda;

public interface VendaRepository extends MongoRepository<Venda, String> {

}

