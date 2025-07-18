package com.litmus7.retailproductcatalogmanager.dto;

/**
 * Generic response wrapper for controller responses. Contains status
 * code, success and error messages, and optional data. Supports generic data
 * types for flexible reuse.
 *
 * @param <T> The type of data being returned in the response.
 */
public class ProductResponse<T> {
	private int statusCode;
	private String errorMessage;
	private String successMessage;
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

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
}
