package com.litmus7.vrs2.dto;

/**
 * A response wrapper class used by the controller layer to send operation
 * results back to the UI.
 */
public class VehicleResponse<T> {
	private int statusCode;
	private String errorMessage;
	private T data;

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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
