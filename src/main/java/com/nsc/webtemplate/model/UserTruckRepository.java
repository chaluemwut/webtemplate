package com.nsc.webtemplate.model;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nsc.webtemplate.model.table.UserTruck;

public interface UserTruckRepository extends MongoRepository<UserTruck, String> {

	UserTruck findByCsUser(String csUser);

}
