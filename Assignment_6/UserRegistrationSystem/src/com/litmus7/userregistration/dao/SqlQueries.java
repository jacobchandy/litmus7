package com.litmus7.userregistration.dao;

public class SqlQueries {
	public static final String INSERT_USER = "INSERT INTO users (username, age, email, password) VALUES (?, ?, ?, ?)";
	public static final String GET_USER = "SELECT username FROM users WHERE email = ? or username = ?";
}
