package com.nsc.webtemplate.model;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nsc.webtemplate.model.table.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
