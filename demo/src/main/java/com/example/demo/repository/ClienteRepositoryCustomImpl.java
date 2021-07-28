package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.example.demo.entity.Cliente;

public class ClienteRepositoryCustomImpl implements ClienteRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Cliente> findByPessoaIdIsNotNull() {
        Query query = new Query();
        Criteria idCriteria = Criteria.where("pessoaId").ne(null);
        return mongoTemplate.find(query, Cliente.class);
    }

}
