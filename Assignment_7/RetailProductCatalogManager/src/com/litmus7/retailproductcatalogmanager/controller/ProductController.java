package com.litmus7.retailproductcatalogmanager.controller;

import java.util.List;

import com.litmus7.retailproductcatalogmanager.dto.*;
import com.litmus7.retailproductcatalogmanager.exception.ProductServiceException;
import com.litmus7.retailproductcatalogmanager.service.ProductService;

/**
 * Acts as a coordination between the UI layer and the service layer. Handles
 * input/output from the application and delegates business logic operations to
 * the ProductService class. Wraps the response in a ProductResponse object with
 * status codes and messages.
 */
public class ProductController {
	private static final int SUCCESS_STATUS_CODE = 200;
	private static final int ERROR_STATUS_CODE = 400;
	private ProductService productService = new ProductService();

	/**
	 * Adds a product.
	 * 
	 * @param product the product to be added
	 * @return response containing status and success/error message
	 */
	public ProductResponse<Void> addProduct(Product product) {
		ProductResponse<Void> response = new ProductResponse<>();
		try {
			productService.addProduct(product);
			response.setStatusCode(SUCCESS_STATUS_CODE);
			response.setSuccessMessage("Product added successfully!");
		} catch (ProductServiceException e) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}

	/**
	 * Fetches a product by ID.
	 * 
	 * @param productId the ID of the product to retrieve
	 * @return response containing the product or error message
	 */
	public ProductResponse<Product> getProduct(int productId) {
		ProductResponse<Product> response = new ProductResponse<>();
		try {
			Product product = productService.getProduct(productId);
			response.setStatusCode(SUCCESS_STATUS_CODE);
			response.setData(product);
		} catch (ProductServiceException e) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}

	/**
	 * Fetches all products.
	 * 
	 * @return response containing list of products or error message
	 */
	public ProductResponse<List<Product>> getAllProducts() {
		ProductResponse<List<Product>> response = new ProductResponse<>();
		try {
			List<Product> products = productService.getAllProducts();
			if (products.isEmpty()) {
				response.setStatusCode(ERROR_STATUS_CODE);
				response.setErrorMessage("No products are available");
				return response;
			}
			response.setStatusCode(SUCCESS_STATUS_CODE);
			response.setData(products);
		} catch (ProductServiceException e) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}

	/**
	 * Updates a product.
	 * 
	 * @param product the updated product
	 * @return response indicating the outcome of the update operation
	 */
	public ProductResponse<Void> updateProduct(Product product) {
		ProductResponse<Void> response = new ProductResponse<>();
		try {
			productService.updateProduct(product);
			response.setStatusCode(SUCCESS_STATUS_CODE);
			response.setSuccessMessage("Product updated successfully");
		} catch (ProductServiceException e) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}

	/**
	 * Deletes a product by ID.
	 * 
	 * @param productId the ID of the product to delete
	 * @return response indicating the result of deletion
	 */
	public ProductResponse<Void> deleteProduct(int productId) {
		ProductResponse<Void> response = new ProductResponse<>();
		try {
			productService.deleteProduct(productId);
			response.setStatusCode(SUCCESS_STATUS_CODE);
			response.setSuccessMessage("Product deleted successfully");
		} catch (ProductServiceException e) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
}
