package com.nsc.webtemplate.api;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonRawValue;
import org.codehaus.jackson.annotate.JsonValue;

public class ResponseData implements Serializable {
	private static final long serialVersionUID = 1220333386624996497L;

	private int statusCode;
	private String description;
	private Object data;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	@JsonValue
	@JsonRawValue
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonValue
	@JsonRawValue
	public Object getData() {
		return data;
	}

	@JsonValue
	@JsonRawValue
	public void setData(Object data) {
		this.data = data;
	}

}
