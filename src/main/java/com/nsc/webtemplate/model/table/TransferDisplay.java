package com.nsc.webtemplate.model.table;

import java.util.Date;

public class TransferDisplay {
	private String id;
	private String truckName;
	private String customerName;
	private String itemName;
	private int numberOfSale;
	private String dateCheckIn;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTruckName() {
		return truckName;
	}

	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getNumberOfSale() {
		return numberOfSale;
	}

	public void setNumberOfSale(int numberOfSale) {
		this.numberOfSale = numberOfSale;
	}

	public String getDateCheckIn() {
		return dateCheckIn;
	}

	public void setDateCheckIn(String dateCheckIn) {
		this.dateCheckIn = dateCheckIn;
	}

}
