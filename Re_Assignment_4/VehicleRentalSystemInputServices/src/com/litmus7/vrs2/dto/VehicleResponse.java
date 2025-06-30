package com.litmus7.vrs2.dto;

import java.util.List;

/**
 * A response wrapper class used by the controller layer to send operation
 * results back to the UI.
 */
public class VehicleResponse {
	private int statusCode;
	private String errorMessage;
	private List<Vehicle> vehicles;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
}
