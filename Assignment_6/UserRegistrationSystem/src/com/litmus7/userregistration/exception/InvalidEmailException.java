package com.litmus7.userregistration.exception;

/**
 * Exception class for representing errors with invalid email format.
 */
public class InvalidEmailException extends Exception {

	public InvalidEmailException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidEmailException(String message) {
		super(message);
	}
}
