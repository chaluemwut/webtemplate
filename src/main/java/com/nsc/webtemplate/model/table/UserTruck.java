package com.nsc.webtemplate.model.table;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_truck")
public class UserTruck {
	@Id
	private String id;
	private String csUser;
	private int csDivision;
	private int csTruck;
	private int csRoute;

	public UserTruck() {
	}

	public UserTruck(String csUser, int csDivision, int csTruck, int csRoute) {
		super();
		this.csUser = csUser;
		this.csDivision = csDivision;
		this.csTruck = csTruck;
		this.csRoute = csRoute;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCsUser() {
		return csUser;
	}

	public void setCsUser(String csUser) {
		this.csUser = csUser;
	}

	public int getCsDivision() {
		return csDivision;
	}

	public void setCsDivision(int csDivision) {
		this.csDivision = csDivision;
	}

	public int getCsTruck() {
		return csTruck;
	}

	public void setCsTruck(int csTruck) {
		this.csTruck = csTruck;
	}

	public int getCsRoute() {
		return csRoute;
	}

	public void setCsRoute(int csRoute) {
		this.csRoute = csRoute;
	}

}
