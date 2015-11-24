package com.nsc.webtemplate.model;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nsc.webtemplate.model.table.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
