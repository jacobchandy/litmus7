package com.litmus7.retailproductcatalogmanager.exception;

public class ProductDataAccessException extends Exception {

	public ProductDataAccessException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductDataAccessException(String message) {
		super(message);
	}
}
