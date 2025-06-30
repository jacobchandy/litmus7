package com.litmus7.vrs2.exception;

/**
 * Exception class for representing file-related errors in the DAO layer of the
 * Vehicle Rental System.
 */
public class VehicleDataAccessException extends Exception {
	public VehicleDataAccessException(String errorMessage) {
		super(errorMessage);
	}

	public VehicleDataAccessException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}
}
