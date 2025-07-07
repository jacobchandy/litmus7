package com.litmus7.userregistration.exception;

/**
 * Exception class for representing errors with invalid age format.
 */
public class InvalidAgeException extends Exception{

	public InvalidAgeException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidAgeException(String message) {
		super(message);
	}
}
