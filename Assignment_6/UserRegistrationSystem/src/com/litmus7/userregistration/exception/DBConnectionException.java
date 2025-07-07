package com.litmus7.userregistration.exception;

/**
 * Exception class for representing errors that occur in the database layer of
 * the User Registration System.
 */
public class DBConnectionException extends Exception {

	public DBConnectionException(String message, Throwable cause) {
		super(message, cause);
	}

	public DBConnectionException(String message) {
		super(message);
	}
}
