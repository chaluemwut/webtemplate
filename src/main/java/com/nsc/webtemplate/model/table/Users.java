package com.nsc.webtemplate.model.table;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * https://dzone.com/articles/spring-data-mongodb-hello
 */
@Document(collection = "users")
public class Users {

	@Id
	private String id;
	private String userName;
	private String passWord;
	private String roleName;

	public Users(String userName, String passWord, String roleName) {
		this.userName = userName;
		this.passWord = passWord;
		this.roleName = roleName;
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

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", roleName=" + roleName + "]";
	}

}