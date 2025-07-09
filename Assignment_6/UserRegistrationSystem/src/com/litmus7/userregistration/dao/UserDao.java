package com.litmus7.userregistration.dao;

import java.sql.*;

import com.litmus7.userregistration.dto.User;
import com.litmus7.userregistration.exception.DBConnectionException;
import com.litmus7.userregistration.exception.UserDataAccessException;
import com.litmus7.userregistration.util.DBUtil;

/**
 * Data Access Object (DAO) Layer is used for adding the user data to the
 * database and also check for existing User.
 */
public class UserDao {
	/**
	 * adding the user to database by using prepared statements.
	 * 
	 * @param user
	 * @throws UserDataAccessException
	 */
	public void addUserToDB(User user) throws UserDataAccessException {
		try {
			try (Connection connection = DBUtil.getConnection();
					PreparedStatement statement = connection.prepareStatement(SqlQueries.INSERT_USER)) {
				statement.setString(1, user.getUsername());
				statement.setInt(2, user.getAge());
				statement.setString(3, user.getEmail());
				statement.setString(4, user.getPassword());

				statement.executeUpdate();

			} catch (SQLException e) {
				throw new UserDataAccessException("Failed to add user", e);
			}
		} catch (DBConnectionException e) {
			throw new UserDataAccessException(e.getMessage(), e);
		}
	}

	/**
	 * Checking for existing Users.
	 * 
	 * @param email
	 * @param username
	 * @return boolean
	 * @throws UserDataAccessException
	 */
	public boolean getUser(String email, String username) throws UserDataAccessException {
		
		try (Connection connection = DBUtil.getConnection(); 
				PreparedStatement statement = connection.prepareStatement(SqlQueries.GET_USER)) {
			statement.setString(1, email);
			statement.setString(2, username);

			return statement.executeQuery().next();

		} catch (SQLException e) {
			throw new UserDataAccessException("Failed to check for existing user", e);
		} catch (DBConnectionException e) {
			throw new UserDataAccessException(e.getMessage(), e);
		}
	}
}
