package com.nsc.webtemplate.model.table;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class Product {
	@Id
	private String id;
	private String csItem;
	private String csItemType;
	private int csStock;
	private int csStock_HIS;
	private int csPreOrder;

	public Product() {
	}

	public Product(String csItem, String csItemType, int csStock, int csStock_HIS, int csPreOrder) {
		this.csItem = csItem;
		this.csItemType = csItemType;
		this.csStock = csStock;
		this.csStock_HIS = csStock_HIS;
		this.csPreOrder = csPreOrder;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCsItem() {
		return csItem;
	}

	public void setCsItem(String csItem) {
		this.csItem = csItem;
	}

	public String getCsItemType() {
		return csItemType;
	}

	public void setCsItemType(String csItemType) {
		this.csItemType = csItemType;
	}

	public int getCsStock() {
		return csStock;
	}

	public void setCsStock(int csStock) {
		this.csStock = csStock;
	}

	public int getCsStock_HIS() {
		return csStock_HIS;
	}

	public void setCsStock_HIS(int csStock_HIS) {
		this.csStock_HIS = csStock_HIS;
	}

	public int getCsPreOrder() {
		return csPreOrder;
	}

	public void setCsPreOrder(int csPreOrder) {
		this.csPreOrder = csPreOrder;
	}

}
