package com.nsc.webtemplate.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 *https://dzone.com/articles/spring-data-mongodb-hello
 */
@Document(collection = "users")
public class Users {

	@Id
	private String id;
	private String userName;
	private String passWord;

	public Users(String userName, String passWord) {
		this.userName = userName;
		this.passWord = passWord;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", passWord=" + passWord + "]";
	}

}