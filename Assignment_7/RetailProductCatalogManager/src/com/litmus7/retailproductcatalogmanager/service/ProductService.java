package com.litmus7.retailproductcatalogmanager.service;

import com.litmus7.retailproductcatalogmanager.dao.*;
import com.litmus7.retailproductcatalogmanager.dao.impl.ProductDAOImpl;
import com.litmus7.retailproductcatalogmanager.dto.Product;
import com.litmus7.retailproductcatalogmanager.exception.*;


public class ProductService {
	private ProductDAO productDao = new ProductDAOImpl();
	
	public void addProduct(Product product) throws ProductServiceException {
		try {
			productDao.addProduct(product);
		}
		catch(ProductDataAccessException e) {
			throw new ProductServiceException(e.getMessage(),e);
		}
	}
	
	public Product getProduct(int id) throws ProductServiceException {
        try {
            Product product = productDao.getProductById(id);
            if (product == null) throw new ProductServiceException("Product with ID " + id + " not found");
            return product;
        } catch (ProductDataAccessException e) {
            throw new ProductServiceException(e.getMessage(), e);
        }
    }
}
