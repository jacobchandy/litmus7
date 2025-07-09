package com.litmus7.retailproductcatalogmanager.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.retailproductcatalogmanager.dto.Product;
import com.litmus7.retailproductcatalogmanager.exception.ProductDataAccessException;
import com.litmus7.retailproductcatalogmanager.util.DBUtil;
import com.litmus7.retailproductcatalogmanager.dao.ProductDAO;

public class ProductDAOImpl implements ProductDAO {
	public void addProduct(Product product) throws ProductDataAccessException {
		String sql = "INSERT INTO products(productId, name, category, price, stockQuantity) VALUES (?, ?, ?, ?, ?)";
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
			preparedStatement.setInt(0, product.getProductId());
			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getCategory());
			preparedStatement.setDouble(3, product.getPrice());
			preparedStatement.setInt(4, product.getStockQuantity());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new ProductDataAccessException("Failed to add Product");
		}
	}

	public Product getProductById(int productId) throws ProductDataAccessException {
		String sql = "SELECT productId, name, category, price, stockQuantity FROM products WHERE productId = ?";
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement prepareStatement = connection.prepareStatement(sql);) {
			prepareStatement.setInt(1, productId);
			
			ResultSet resultSet = prepareStatement.executeQuery();
			
			if (resultSet.next()) {
				productId = resultSet.getInt("productId");
	            String name = resultSet.getString("name");
	            String category = resultSet.getString("category");
	            double price = resultSet.getDouble("price");
	            int stockQuantity = resultSet.getInt("stockQuantity");
	            
	            return new Product(productId ,name, category, price, stockQuantity);
	        }

		} catch (SQLException e) {
			throw new ProductDataAccessException("Failed to get Product by ID");
		}
		return null;
	}
	
	public List<Product> getAllProducts() throws ProductDataAccessException{
		String sql = "SELECT productId, name, category, price, stockQuantity FROM products";
		List<Product> products = new ArrayList<>();
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery();){
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
		}
		return products;
	}
	
	public void updateProduct(Product product) throws ProductDataAccessException {

		String sql = "UPDATE products SET name = ?, category = ?, price = ?, stockQuantity = ? WHERE productId = ?";
		
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
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
		}
	}
	
	public void deleteProduct(int productId) throws ProductDataAccessException  {
	    String sql = "DELETE FROM products WHERE productId = ?";

	    try (Connection connection = DBUtil.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

	        preparedStatement.setInt(1, productId);
	        
	        if (preparedStatement.executeUpdate() == 0) {
	        	throw new ProductDataAccessException("No product found to delete");
	        }
	        
	    } catch (SQLException e) {
	    	throw new ProductDataAccessException("Deletion Failed");
	    }
	}

}
