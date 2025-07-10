package com.litmus7.retailproductcatalogmanager.exception;

/**
 * Custom exception indicating an issue in the database connection.
 */
public class DBConnectionException extends Exception {
	public DBConnectionException(String message, Throwable cause) {
		super(message, cause);
	}

	public DBConnectionException(String message) {
		super(message);
	}
}
