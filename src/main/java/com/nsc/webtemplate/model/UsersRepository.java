package com.nsc.webtemplate.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends MongoRepository<Users, String> {

	Users findByUserNameAndPassWord(String userName, String passWord);
	
}
