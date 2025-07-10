package com.litmus7.retailproductcatalogmanager.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.retailproductcatalogmanager.dto.Product;
import com.litmus7.retailproductcatalogmanager.exception.DBConnectionException;
import com.litmus7.retailproductcatalogmanager.exception.ProductDataAccessException;
import com.litmus7.retailproductcatalogmanager.util.DBUtil;
import com.litmus7.retailproductcatalogmanager.dao.ProductDAO;
import com.litmus7.retailproductcatalogmanager.dao.SQLQueries;

/**
 * Concrete implementation of ProductDAO. Interacts with the database using JDBC
 * to perform CRUD operations for Product entities.
 */
public class ProductDAOImpl implements ProductDAO {
	/** Adds a product to the database */
	public void addProduct(Product product) throws ProductDataAccessException {
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.INSERT_INTO_PRODUCT);) {
			preparedStatement.setInt(1, product.getProductId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setString(3, product.getCategory());
			preparedStatement.setDouble(4, product.getPrice());
			preparedStatement.setInt(5, product.getStockQuantity());

			preparedStatement.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException e) {
			throw new ProductDataAccessException("Product already exists");
		} catch (SQLException e) {
			throw new ProductDataAccessException("Failed to add Product");
		} catch (DBConnectionException e) {
			throw new ProductDataAccessException(e.getMessage());
		}
	}

	/** Retrieves a product by ID */
	public Product getProductById(int productId) throws ProductDataAccessException {
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement prepareStatement = connection.prepareStatement(SQLQueries.GET_PRODUCT_BY_ID);) {
			prepareStatement.setInt(1, productId);

			ResultSet resultSet = prepareStatement.executeQuery();

			if (resultSet.next()) {
				productId = resultSet.getInt("productId");
				String name = resultSet.getString("name");
				String category = resultSet.getString("category");
				double price = resultSet.getDouble("price");
				int stockQuantity = resultSet.getInt("stockQuantity");

				return new Product(productId, name, category, price, stockQuantity);
			}

		} catch (SQLException e) {
			throw new ProductDataAccessException("Failed to get Product by ID");
		} catch (DBConnectionException e) {
			throw new ProductDataAccessException(e.getMessage());
		}
		return null;
	}

	/** Retrieves all products */
	public List<Product> getAllProducts() throws ProductDataAccessException {
		List<Product> products = new ArrayList<>();
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.GET_ALL_PRODUCTS);
				ResultSet resultSet = preparedStatement.executeQuery();) {
			while (resultSet.next()) {
				int productId = resultSet.getInt("productId");
				String name = resultSet.getString("name");
				String category = resultSet.getString("category");
				double price = resultSet.getDouble("price");
				int stockQuantity = resultSet.getInt("stockQuantity");

				products.add(new Product(productId, name, category, price, stockQuantity));
			}

		} catch (SQLException e) {
			throw new ProductDataAccessException("Failed to get Products", e);
		} catch (DBConnectionException e) {
			throw new ProductDataAccessException(e.getMessage());
		}
		return products;
	}

	/** Updates a product */
	public void updateProduct(Product product) throws ProductDataAccessException {
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.UPDATE_PRODUCT);) {
			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getCategory());
			preparedStatement.setDouble(3, product.getPrice());
			preparedStatement.setInt(4, product.getStockQuantity());
			preparedStatement.setInt(5, product.getProductId());

			if (preparedStatement.executeUpdate() == 0) {
				throw new ProductDataAccessException("No product found to update");
			}
		} catch (SQLException e) {
			throw new ProductDataAccessException("Updating Product Failed");
		} catch (DBConnectionException e) {
			throw new ProductDataAccessException(e.getMessage());
		}
	}

	/** Deletes a product by ID */
	public void deleteProduct(int productId) throws ProductDataAccessException {
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.DELETE_PRODUCT)) {

			preparedStatement.setInt(1, productId);

			if (preparedStatement.executeUpdate() == 0) {
				throw new ProductDataAccessException("No product found to delete");
			}

		} catch (SQLException e) {
			throw new ProductDataAccessException("Deletion Failed");
		} catch (DBConnectionException e) {
			throw new ProductDataAccessException(e.getMessage());
		}
	}
}
