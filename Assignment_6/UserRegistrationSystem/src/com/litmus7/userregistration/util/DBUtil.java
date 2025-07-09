package com.litmus7.userregistration.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.litmus7.userregistration.exception.DBConnectionException;

/**
 * DB utility class is used to connect to the database.
 */
public class DBUtil {
    
    private static String url;
    private static String username;
    private static String password;

    static {
		try (InputStream input = DBUtil.class.getClassLoader().getResourceAsStream("user.properties")) {
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
     * Establish a connection to the database.
     *
     * @return 
     * @throws DBConnectionException 
     */
    public static Connection getConnection() throws DBConnectionException {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new DBConnectionException("Failed to connect to the database", e);
        }
    }
}
