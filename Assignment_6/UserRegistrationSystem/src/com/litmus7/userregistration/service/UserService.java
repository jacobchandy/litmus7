package com.litmus7.userregistration.service;

import com.litmus7.userregistration.dao.UserDao;
import com.litmus7.userregistration.dto.User;
import com.litmus7.userregistration.exception.*;

/**
 * Service Class contains the business logic of the User Registration System.
 * Handles operations to registration and validating the user.
 */
public class UserService {
	private UserDao userDao = new UserDao();

	/**
	 * Registering the user into the database
	 * 
	 * @param username
	 * @param age
	 * @param email
	 * @param password
	 * @return User object
	 * @throws InvalidAgeException
	 * @throws InvalidEmailException
	 * @throws WeakPasswordException
	 * @throws UserServiceException
	 */
	public User registerUser(String username, int age, String email, String password)
			throws InvalidAgeException, InvalidEmailException, WeakPasswordException, UserServiceException {

		validateUser(age, email, password);
		User user = new User(username, age, email, password);

		try {
			if (userDao.userExists(email, username)) {
				throw new UserServiceException("A user already exists");
			}
			userDao.addUserToDB(user);
		} catch (UserDataAccessException e) {
			throw new UserServiceException("Failed to register user: " + e.getMessage(), e);
		}
		return user;
	}

	/**
	 * Validating the User. Checking for age, email, and password.
	 * 
	 * @param age
	 * @param email
	 * @param password
	 * @throws InvalidAgeException
	 * @throws InvalidEmailException
	 * @throws WeakPasswordException
	 */
	public void validateUser(int age, String email, String password)
			throws InvalidAgeException, InvalidEmailException, WeakPasswordException {
		if (age < 18 || age > 60) {
			throw new InvalidAgeException("Age must be within 18 and 60");
		}
		if (!email.contains("@") || (!email.contains("."))) {
			throw new InvalidEmailException("Invalid email format. Must contain '@' and '.'");
		}
		if (password.length() < 6) {
			throw new WeakPasswordException("Password is weak! Must be at least 6 characters.");
		}
	}
}
