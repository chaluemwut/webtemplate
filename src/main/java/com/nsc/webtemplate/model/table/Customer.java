package com.nsc.webtemplate.model.table;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
public class Customer {
	@Id
	private String id;
	private String csCustomerId;
	private String csCustomerName;
	private String csAddress;
	private int csRoute;

	public Customer() {
	}

	public Customer(String csCustomerId, String csCustomerName, String csAddress, int csRoute) {
		this.csCustomerId = csCustomerId;
		this.csCustomerName = csCustomerName;
		this.csAddress = csAddress;
		this.csRoute = csRoute;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCsCustomerId() {
		return csCustomerId;
	}

	public void setCsCustomerId(String csCustomerId) {
		this.csCustomerId = csCustomerId;
	}

	public String getCsCustomerName() {
		return csCustomerName;
	}

	public void setCsCustomerName(String csCustomerName) {
		this.csCustomerName = csCustomerName;
	}

	public String getCsAddress() {
		return csAddress;
	}

	public void setCsAddress(String csAddress) {
		this.csAddress = csAddress;
	}

	public int getCsRoute() {
		return csRoute;
	}

	public void setCsRoute(int csRoute) {
		this.csRoute = csRoute;
	}

}
