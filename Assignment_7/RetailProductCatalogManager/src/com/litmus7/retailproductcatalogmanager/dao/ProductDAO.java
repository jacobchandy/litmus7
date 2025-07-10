package com.litmus7.retailproductcatalogmanager.dao;

import java.util.List;

import com.litmus7.retailproductcatalogmanager.dto.Product;
import com.litmus7.retailproductcatalogmanager.exception.ProductDataAccessException;

/**
 * Defines data access operations for Product entities. This interface abstracts
 * the CRUD operations that are implemented in the ProductDAOImpl class for
 * persistence in a relational database.
 */
public interface ProductDAO {
	void addProduct(Product product) throws ProductDataAccessException;

	Product getProductById(int productId) throws ProductDataAccessException;

	List<Product> getAllProducts() throws ProductDataAccessException;

	void updateProduct(Product product) throws ProductDataAccessException;

	void deleteProduct(int productId) throws ProductDataAccessException;
}
