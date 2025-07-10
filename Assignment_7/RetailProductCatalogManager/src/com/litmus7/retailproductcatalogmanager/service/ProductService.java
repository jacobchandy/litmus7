package com.litmus7.retailproductcatalogmanager.service;

import java.util.List;

import com.litmus7.retailproductcatalogmanager.dao.*;
import com.litmus7.retailproductcatalogmanager.dao.impl.ProductDAOImpl;
import com.litmus7.retailproductcatalogmanager.dto.Product;
import com.litmus7.retailproductcatalogmanager.exception.*;

/**
 * Provides business logic for product operations. Validates and delegates data
 * operations to the DAO layer.
 */

public class ProductService {
	private ProductDAO productDao = new ProductDAOImpl();

	/**
	 * Adds a new product.
	 * 
	 * @param product the product to add
	 * @throws ProductServiceException if addition fails
	 */
	public void addProduct(Product product) throws ProductServiceException {
		try {
			productDao.addProduct(product);
		} catch (ProductDataAccessException e) {
			throw new ProductServiceException(e.getMessage(), e);
		}
	}

	/**
	 * Retrieves a product by ID.
	 * 
	 * @param id the product ID
	 * @return the retrieved product
	 * @throws ProductServiceException if retrieval fails or product not found
	 */
	public Product getProduct(int id) throws ProductServiceException {
		try {
			Product product = productDao.getProductById(id);
			if (product == null)
				throw new ProductServiceException("Product with ID " + id + " not found");
			return product;
		} catch (ProductDataAccessException e) {
			throw new ProductServiceException(e.getMessage(), e);
		}
	}

	/**
	 * Retrieves all products.
	 * 
	 * @return list of all products
	 * @throws ProductServiceException if retrieval fails
	 */
	public List<Product> getAllProducts() throws ProductServiceException {
		try {
			return productDao.getAllProducts();
		} catch (ProductDataAccessException e) {
			throw new ProductServiceException(e.getMessage(), e);
		}
	}

	/**
	 * Updates a product.
	 * 
	 * @param product the product to update
	 * @throws ProductServiceException if update fails
	 */
	public void updateProduct(Product product) throws ProductServiceException {
		try {
			productDao.updateProduct(product);
		} catch (ProductDataAccessException e) {
			throw new ProductServiceException(e.getMessage(), e);
		}
	}

	/**
	 * Deletes a product.
	 * 
	 * @param id the product ID
	 * @throws ProductServiceException if deletion fails
	 */
	public void deleteProduct(int id) throws ProductServiceException {
		try {
			productDao.deleteProduct(id);
		} catch (ProductDataAccessException e) {
			throw new ProductServiceException(e.getMessage(), e);
		}
	}
}
