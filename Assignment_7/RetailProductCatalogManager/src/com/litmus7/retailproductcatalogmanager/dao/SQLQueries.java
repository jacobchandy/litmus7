package com.litmus7.retailproductcatalogmanager.dao;

public class SQLQueries {
	public static final String INSERT_INTO_PRODUCT = "INSERT INTO products(productId, name, category, price, stockQuantity) VALUES (?, ?, ?, ?, ?)";
	public static final String GET_PRODUCT_BY_ID = "SELECT productId, name, category, price, stockQuantity FROM products WHERE productId = ?";
	public static final String GET_ALL_PRODUCTS = "SELECT productId, name, category, price, stockQuantity FROM products";
	public static final String UPDATE_PRODUCT = "UPDATE products SET name = ?, category = ?, price = ?, stockQuantity = ? WHERE productId = ?";
	public static final String DELETE_PRODUCT = "DELETE FROM products WHERE productId = ?";
}
