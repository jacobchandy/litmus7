package com.litmus7.vrs2.exception;

/**
 * Exception class for representing errors that occur in the service layer of
 * the Vehicle Rental System.
 */
public class VehicleServiceException extends Exception {
	public VehicleServiceException(String errorMessage) {
		super(errorMessage);
	}

	public VehicleServiceException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}
}
