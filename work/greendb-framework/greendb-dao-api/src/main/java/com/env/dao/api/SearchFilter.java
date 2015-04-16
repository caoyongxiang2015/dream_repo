package com.env.dao.api;

/**
 * 
 */

import java.io.Serializable;

/**
 */
public class SearchFilter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 操作<br>
	 * =;!=;&gt;;&lt;;&gt;=;&lt;=;like;not like;
	 */
	private String operation;

	/**
	 * 比较的值
	 */
	private Object value;

	public SearchFilter() {
		// TODO Auto-generated constructor stub
	}

	public SearchFilter(String operation, Object value) {
		setOperation(operation);
		setValue(value);
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
