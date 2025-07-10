package com.litmus7.retailproductcatalogmanager.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.litmus7.retailproductcatalogmanager.exception.*;

/**
 * Utility class for managing JDBC database connections. Loads database
 * configuration from `db.properties` and provides a method to get JDBC
 * connections.
 */
public class DBUtil {
	private static String url;
	private static String username;
	private static String password;
	private static final String dbConfig = "db.properties";
	static {
		try (InputStream input = DBUtil.class.getClassLoader().getResourceAsStream(dbConfig)) {
			Properties props = new Properties();
			if (input == null) {
				throw new RuntimeException("Unable to find db properties");
			}
			props.load(input);

			url = props.getProperty("jdbc.url");
			username = props.getProperty("jdbc.username");
			password = props.getProperty("jdbc.password");
		} catch (IOException e) {
			throw new RuntimeException("Failed to load DB configuration");
		}
	}

	/**
	 * Returns a new database connection using credentials from properties file.
	 * 
	 * @return a JDBC Connection
	 * @throws SQLException if connection fails
	 */
	public static Connection getConnection() throws DBConnectionException {
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			throw new DBConnectionException("Failed to connect to the database", e);
		}
	}
}
