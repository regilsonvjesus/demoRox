package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.ItemVenda;

public interface ItemVendaRepository extends MongoRepository<ItemVenda, String> {

}

