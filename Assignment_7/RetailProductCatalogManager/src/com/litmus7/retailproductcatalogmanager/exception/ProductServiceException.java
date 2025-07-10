package com.litmus7.retailproductcatalogmanager.exception;

/**
 * Custom exception indicating an issue in the service layer.
 */
public class ProductServiceException extends Exception {
	public ProductServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductServiceException(String message) {
		super(message);
	}
}
