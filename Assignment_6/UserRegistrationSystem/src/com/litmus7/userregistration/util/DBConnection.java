package com.litmus7.userregistration.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import com.litmus7.userregistration.exception.DBConnectionException;

/**
 * DB utility class is used to connect to the database.
 */
public class DBConnection {
	/**
	 * Establish a connection to the database
	 * 
	 * @return
	 * @throws DBConnectionException
	 */
	public Connection DBConnect() throws DBConnectionException {
		Connection connection = null;

		try {
			Properties props = new Properties();
			props.load(new FileInputStream("src/com/litmus7/userregistration/util/user.properties"));

			String user = props.getProperty("user");
			String password = props.getProperty("password");
			String dburl = props.getProperty("dburl");

			connection = DriverManager.getConnection(dburl, user, password);
		} catch (SQLException e) {
			throw new DBConnectionException("Failed to connect to the database", e);
		} catch (FileNotFoundException e) {
			throw new DBConnectionException("Configuration file not found", e);
		} catch (IOException e) {
			throw new DBConnectionException("Failed to load database configuration", e);
		}
		return connection;
	}
}
