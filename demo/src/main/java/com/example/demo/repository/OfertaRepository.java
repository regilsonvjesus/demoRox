package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.Oferta;

public interface OfertaRepository extends MongoRepository<Oferta, String> {

}

