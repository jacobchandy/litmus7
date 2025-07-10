package com.litmus7.retailproductcatalogmanager.exception;

/**
 * Custom exception indicating an issue in the data access layer.
 */
public class ProductDataAccessException extends Exception {
	public ProductDataAccessException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductDataAccessException(String message) {
		super(message);
	}
}
