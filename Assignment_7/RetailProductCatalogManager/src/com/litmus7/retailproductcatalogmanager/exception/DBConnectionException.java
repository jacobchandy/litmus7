package com.litmus7.retailproductcatalogmanager.exception;

public class DBConnectionException extends Exception {

	public DBConnectionException(String message, Throwable cause) {
		super(message, cause);
	}

	public DBConnectionException(String message) {
		super(message);
	}
}

