package com.litmus7.userregistration.exception;

/**
 * Exception class for representing database-related errors in the DAO layer of
 * the User Registration System.
 */
public class UserDataAccessException extends Exception {

	public UserDataAccessException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserDataAccessException(String message) {
		super(message);
	}
}
