package com.litmus7.userregistration.exception;

/**
 * Exception class for representing errors that occur in the service layer of
 * the User Registration System.
 */
public class UserServiceException extends Exception {

	public UserServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserServiceException(String message) {
		super(message);
	}
}
