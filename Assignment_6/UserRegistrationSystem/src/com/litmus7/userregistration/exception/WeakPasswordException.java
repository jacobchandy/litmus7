package com.litmus7.userregistration.exception;

/**
 * Exception class for representing errors with weak password.
 */
public class WeakPasswordException extends Exception {

	public WeakPasswordException(String message, Throwable cause) {
		super(message, cause);
	}

	public WeakPasswordException(String message) {
		super(message);
	}

}
