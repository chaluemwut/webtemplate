package com.nsc.webtemplate.model;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nsc.webtemplate.model.table.TransferData;

public interface TransferRepository extends MongoRepository<TransferData, String> {

}
